package net.manmaed.petrock.entity;

import net.manmaed.petrock.item.PRItems;
import net.manmaed.petrock.sounds.PRSounds;
import net.manmaed.petrock.tag.PRTags;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
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
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by manmaed on 14/06/2022.
 */
public class EntityPetRockWithLegs extends TamableAnimal {

    private static final EntityDataAccessor<Integer> VARIANT_ID = SynchedEntityData.defineId(EntityPetRockWithLegs.class, EntityDataSerializers.INT);

    protected EntityPetRockWithLegs(EntityType<? extends TamableAnimal> type, Level worldIn) {
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

    public boolean isRockVariantChangeItem(ItemStack itemStack) {
        itemStack.is(PRTags.PETROCK_STONE_VARIANT);
        List<TagKey<Item>> tagKeys = itemStack.getTags().toList();
        if (tagKeys.contains(PRTags.PETROCK_STONE_VARIANT)) { return true; }
        else if (tagKeys.contains(PRTags.PETROCK_NETHER_VARIANT)) { return true; }
        else if (tagKeys.contains(PRTags.PETROCK_END_VARIANT)) { return true; }
        else if (tagKeys.contains(PRTags.PETROCK_DEEPSLATE_VARIANT)) { return true; }
        else if (tagKeys.contains(PRTags.PETROCK_DIORITE_VARIANT)) { return true; }
        else if (tagKeys.contains(PRTags.PETROCK_GRANITE_VARIANT)) { return true; }
        else if (tagKeys.contains(PRTags.PETROCK_ANDASITE_VARIANT)) { return true; }
        else if (tagKeys.contains(PRTags.PETROCK_CLAY_VARIANT)) { return true; }
        else if (tagKeys.contains(PRTags.PETROCK_BEDROCK_VARIANT)) { return true; }
        else if (tagKeys.contains(PRTags.PETROCK_MISSINGNO_VARIANT)) { return true; }
        else return false;
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return itemStack.is(PRTags.PETROCK_FOOD);
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        Item item = itemStack.getItem();
        Level level = this.level();
        if (level.isClientSide  || this.isBaby() && this.isFood(itemStack)) {
            boolean flag = this.isOwnedBy(player) || this.isTame() || itemStack.is(PRItems.STONEIUM) && !this.isTame();
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            if (this.isTame()) {
                if (this.isFood(itemStack) && this.getHealth() < this.getMaxHealth()) {
                    if (!player.getAbilities().instabuild) {
                        itemStack.shrink(1);
                    }
                    this.heal(3.0F);
                    return InteractionResult.SUCCESS;
                }
                if (isRockVariantChangeItem(itemStack)) {
                    rightClickSetRockVariant(itemStack, player);
                    return InteractionResult.SUCCESS;
                }
                else  {
                    InteractionResult interactionresult = super.mobInteract(player, hand);
                    if (!interactionresult.consumesAction() && this.isOwnedBy(player)) {
                        //LogHelper.warn("before setting sit " + this.isOrderedToSit());
                        this.setOrderedToSit(!this.isOrderedToSit());
                        //LogHelper.warn("after setting sit " + this.isOrderedToSit());
                        this.jumping = false;
                        this.navigation.stop();
                        return InteractionResult.SUCCESS_NO_ITEM_USED;
                    }

                    return interactionresult;
                }
            } else if (item == PRItems.ULTIMATE_STONEIUM.get()) {
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
                makeTame(player);
                return InteractionResult.SUCCESS;
            } else if (item == PRItems.STONEIUM.get()) {
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
                tryToTame(player);
                //playSound(SoundEvents.GENERIC_DRINK, getSoundVolume(), 1F);
                return InteractionResult.SUCCESS;
            }
            return super.mobInteract(player, hand);
        }
    }
    private void tryToTame(Player player) {
        if (this.random.nextInt(3) == 0) {
            makeTame(player);
        } else {
            this.level().broadcastEntityEvent(this, (byte) 6);
        }
    }

    private void makeTame(Player player) {
        this.tame(player);
        this.navigation.stop();
        this.setOrderedToSit(true);
        this.level().broadcastEntityEvent(this, (byte) 7);
        //TOTEM_USE maybe
        playSound(PRSounds.PETROCK_TAME.get(), getSoundVolume(), 1F);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        playSound(PRSounds.PETROCK_MATE.get(), getSoundVolume(), 1F);
        EntityPetRockWithLegs petRock = new EntityPetRockWithLegs((PREntityTypes.PETROCKWITHLEGS.get()), serverLevel);
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
            case 9:
                name = "squidgy";
                break;
            default:
                name = "stone";
                break;
        }
        return name;
    }

    private void rightClickSetRockVariant(ItemStack itemStack, Player player) {
        List<TagKey<Item>> tagKeys = itemStack.getTags().toList();
        if (tagKeys.contains(PRTags.PETROCK_STONE_VARIANT)) { setVariant(0); }
        else if (tagKeys.contains(PRTags.PETROCK_NETHER_VARIANT)) { setVariant(1); }
        else if (tagKeys.contains(PRTags.PETROCK_END_VARIANT)) { setVariant(2); }
        else if (tagKeys.contains(PRTags.PETROCK_DEEPSLATE_VARIANT)) { setVariant(3); }
        else if (tagKeys.contains(PRTags.PETROCK_DIORITE_VARIANT)) { setVariant(4); }
        else if (tagKeys.contains(PRTags.PETROCK_GRANITE_VARIANT)) { setVariant(5); }
        else if (tagKeys.contains(PRTags.PETROCK_ANDASITE_VARIANT)) { setVariant(6); }
        else if (tagKeys.contains(PRTags.PETROCK_CLAY_VARIANT)) { setVariant(7); }
        else if (tagKeys.contains(PRTags.PETROCK_BEDROCK_VARIANT)) { setVariant(8); }
        else if (tagKeys.contains(PRTags.PETROCK_MISSINGNO_VARIANT)) { setVariant(-1); }
    }

    @Override
    public void tick() {
        super.tick();
        //System.out.println(getVariant());
        if (getVariant() == null) {
            setVariant(0);
        }
        if (hasCustomName()) {
            String customName = this.getCustomName().getString();
            if (customName.equals("Squidgy") && getVariant() != 9) {
                setVariant(9);
            }
        }
    }
}
