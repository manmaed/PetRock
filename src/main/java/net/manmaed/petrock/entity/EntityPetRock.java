package net.manmaed.petrock.entity;

import net.manmaed.petrock.item.PRItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by manmaed on 07/03/2021.
 */
public class EntityPetRock extends TamableAnimal {

    private static final EntityDataAccessor<Integer> VARIANT_ID = SynchedEntityData.defineId(EntityPetRock.class, EntityDataSerializers.INT);


    protected EntityPetRock(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn);
        this.setTame(false, false);
    }

    protected void registerGoals() {
        //Goal Selectors
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F));
        this.goalSelector.addGoal(4, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        //Target Selectors
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setAlertOthers());
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder synceddata) {
        super.defineSynchedData(synceddata);
        //synceddata.define(VARIANT_ID, random.nextInt(6)); //Randomly set the rocks variant
        synceddata.define(VARIANT_ID, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("rock_variant", this.getVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (compoundTag.contains("rock_variant")) {
            this.setVariant(compoundTag.getInt("rock_variant"));
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 2.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }


    //Sounds
    @Override
    protected void playStepSound(BlockPos p_20135_, BlockState p_20136_) {
        this.playSound(SoundEvents.STONE_STEP, 0.15F, 1.0F);
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.STONE_BREAK;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.STONE_BREAK;
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }
    //End Of Sounds


    @Override
    public void setTame(boolean tame1, boolean tame2) {
        super.setTame(tame1, tame2);
        if (tame1) {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20.0D);
            this.setHealth(20.0F);
        } else {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(2.0D);
        }
    }

    public boolean isRockVariantChangeItem(Item item) {
        Item[] changeItems = {
                //Add Items Here For allowed Variant Change
                //will also need a texture and added to rightClickSetRockVariant & getVariantName
                Blocks.STONE.asItem(),
                Blocks.NETHERRACK.asItem(),
                Blocks.END_STONE.asItem(),
                Blocks.DEEPSLATE.asItem(),
                Blocks.DIORITE.asItem(),
                Blocks.GRANITE.asItem(),
                Blocks.ANDESITE.asItem(),
                Blocks.CLAY.asItem(),
                Blocks.BEDROCK.asItem()
        };
        for (Item itemloop: changeItems) {
            if (item == itemloop) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return itemStack == PRItems.STONEIUM.get().getDefaultInstance();
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        Item item = itemStack.getItem();
        Level level = this.level();
        if (level.isClientSide) {
            boolean flag = this.isOwnedBy(player) || this.isTame() || item == PRItems.STONEIUM.get() && !this.isTame();
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            if (this.isTame()) {
                if (item == PRItems.KIBBLE.get() && this.getHealth() < this.getMaxHealth()) {
                    if (!player.getAbilities().instabuild) {
                        itemStack.shrink(1);
                    }
                    this.heal(3.0F);
                    return InteractionResult.SUCCESS;
                }
                if (isRockVariantChangeItem(item)) {
                    rightClickSetRockVariant(itemStack, player);
                    return InteractionResult.SUCCESS;
                }
                if (!(item instanceof DyeItem)) {
                    InteractionResult interactionresult = super.mobInteract(player, hand);
                    if ((!interactionresult.consumesAction() || this.isBaby()) && this.isOwnedBy(player)) {
                        //LogHelper.warn("before setting sit " + this.isOrderedToSit());
                        this.setOrderedToSit(!this.isOrderedToSit());
                        //LogHelper.warn("after setting sit " + this.isOrderedToSit());
                        this.jumping = false;
                        this.navigation.stop();
                        return InteractionResult.SUCCESS;
                    }

                    return interactionresult;
                }
            } else if (item == PRItems.STONEIUM.get()) {
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
                if (this.random.nextInt(3) == 0) {
                    this.tame(player);
                    this.navigation.stop();
                    this.setOrderedToSit(true);
                    level.broadcastEntityEvent(this, (byte) 7);
                    //TOTEM_USE maybe
                    //playSound(PSSounds.SLOW_TAME.get(), getSoundVolume(), 1F);
                } else {
                    level.broadcastEntityEvent(this, (byte) 6);
                }
                //playSound(SoundEvents.GENERIC_DRINK, getSoundVolume(), 1F);
                return InteractionResult.SUCCESS;
            }
            return super.mobInteract(player, hand);
        }
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        EntityPetRock petRock = new EntityPetRock((PREntityTypes.PETROCK.get()), serverLevel);
        UUID uuid = this.getOwnerUUID();
        if (uuid != null) {
            petRock.setOwnerUUID(uuid);
            petRock.setTame(true, true);
        }
        return petRock;
    }

    public void setVariant(Integer variant) {
        this.entityData.set(VARIANT_ID, variant);
    }

    public Integer getVariant() {
        return this.entityData.get(VARIANT_ID);
    }

    public String getVariantName(){
        int type = this.getVariant();
        String name;
        switch (type) {
            case -1:
                name = "missingno";
                break;
            case 1:
                name = "nether";
                break;
            case 2:
                name = "end";
                break;
            case 3:
                name = "deepslate";
                break;
            case 4:
                name = "diorite";
                break;
            case 5:
                name = "granite";
                break;
            case 6:
                name = "andesite";
                break;
            case 7:
                name = "clay";
                break;
            case 8:
                name = "bedrock";
                break;
            default:
                name = "stone";
                break;
        }
        return name;
    }

    private void rightClickSetRockVariant(ItemStack itemStack, Player player) {
        Item item = itemStack.getItem();
        String itemName = item.toString();
        // Use regex to extract the part after the colon
        String regex = "(?<=:)[^:]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(itemName);
        // Extract the part after the colon
        String extractedName = "missingno"; //Should allways be replaced
        if (matcher.find()) {
            extractedName = matcher.group();
        }
        if (!player.getAbilities().instabuild) {
            itemStack.shrink(1);
        }
        //System.out.println("Item We got " + extractedName);
        switch (extractedName) {
            case "stone":
                setVariant(0);
                break;
            case "netherrack":
                setVariant(1);
                break;
            case "end_stone":
                setVariant(2);
                break;
            case "deepslate":
                setVariant(3);
                break;
            case "diorite":
                setVariant(4);
                break;
            case "granite":
                setVariant(5);
                break;
            case "andesite":
                setVariant(6);
                break;
            case "clay":
                setVariant(7);
                break;
            case "bedrock":
                setVariant(8);
                break;
            case "missingno":
                setVariant(-1);
                break;
        }
    }

    @Override
    public void tick() {
        super.tick();
        //System.out.println(getVariant());
        if (getVariant() == null) {
            setVariant(0);
        }
    }
}
