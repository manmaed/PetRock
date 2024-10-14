package net.manmaed.petrock.datagen;

import net.manmaed.petrock.entity.PREntityTypes;
import net.manmaed.petrock.item.PRItems;
import net.manmaed.petrock.libs.RLHelper;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.KilledTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class PRAdvancementProvider extends AdvancementProvider {
    public PRAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, List.of(new PRAdvancementGenerator()));
    }

    public static class PRAdvancementGenerator implements AdvancementGenerator {

        @Override
        public void generate(HolderLookup.Provider lookups, Consumer<AdvancementHolder> consumer, ExistingFileHelper existingFileHelper) {

            //ROOT Advancemnt
            AdvancementHolder root = Advancement.Builder.advancement()
                    .display(makeRootInfo(PRItems.PETROCKBOX.get(), "stone", true))
                    .addCriterion("get_pick_to_mine_stoneium", inventoryChangedTrigger(Items.STONE_PICKAXE))
                    .save(consumer, getSaveLoc("root"));

            //MineStoneium
            AdvancementHolder mineStoneium = Advancement.Builder.advancement()
                    .display(info(PRItems.RAW_STONEIUM.get(), "mine_stoneium", AdvancementType.TASK, true, true ,false))
                    .parent(root)
                    .addCriterion("get_raw_stoneium", inventoryChangedTrigger(PRItems.RAW_STONEIUM.get()))
                    .save(consumer, getSaveLoc("mine_stoneium"));

            //Cook Raw Stoneium to Stoneium
            AdvancementHolder cookStoneiun = Advancement.Builder.advancement()
                    .display(info(PRItems.STONEIUM.get(), "cook_raw_stoneium", AdvancementType.TASK, true, true ,false))
                    .parent(mineStoneium)
                    .addCriterion("cook_raw_stoneium", inventoryChangedTrigger(PRItems.STONEIUM.get()))
                    .save(consumer, getSaveLoc("cook_raw_stoneium"));

            //Make a Order Form
            AdvancementHolder orderPetRock = Advancement.Builder.advancement()
                    .display(info(PRItems.ORDER_FORM.get(), "order_form", AdvancementType.TASK,true, true, false))
                    .parent(root)
                    .addCriterion("order_form", inventoryChangedTrigger(PRItems.ORDER_FORM.get()))
                    .save(consumer, getSaveLoc("order_form"));

            //Get A PetRock
            AdvancementHolder petrockget = Advancement.Builder.advancement()
                    .display(info(PRItems.PETROCKBOX.get(), "get_petrock", AdvancementType.GOAL, true, true, false))
                    .parent(orderPetRock)
                    .addCriterion("get_petrock", inventoryChangedTrigger(PRItems.PETROCKBOX.get()))
                    .save(consumer, getSaveLoc("get_petrock"));

            //PetRock With Legs
            AdvancementHolder petrockwithlegs = Advancement.Builder.advancement()
                    .display(info(PRItems.PETROCKWITHLEGSBOX.get(), "get_petrock_with_legs", AdvancementType.GOAL, true, true, false))
                    .parent(orderPetRock)
                    .addCriterion("get_petrock_with_legs", inventoryChangedTrigger(PRItems.PETROCKWITHLEGSBOX.get()))
                    .save(consumer, getSaveLoc("get_petrock_with_legs"));

            //Kill a Petrock
            AdvancementHolder killpetrock  = Advancement.Builder.advancement()
                    .display(info(Items.DIAMOND_SWORD, "warranty_void", AdvancementType.CHALLENGE, true, true, true))
                    .parent(petrockget)
                    .addCriterion("kill_petrock", killEntityTrigger(PREntityTypes.PETROCK.get()))
                    .save(consumer, getSaveLoc("petrock_warranty_void"));

            AdvancementHolder killpetrocwithlegs  = Advancement.Builder.advancement()
                    .display(info(Items.DIAMOND_SWORD, "warranty_void", AdvancementType.CHALLENGE, true, true, true))
                    .parent(petrockwithlegs)
                    .addCriterion("kill_petrock_with_legs", killEntityTrigger(PREntityTypes.PETROCKWITHLEGS.get()))
                    .save(consumer, getSaveLoc("petrock_with_legs_warranty_void"));

            //Make Kibble to heal a PetRock
            AdvancementHolder healpetrock = Advancement.Builder.advancement()
                    .display(info(PRItems.KIBBLE.get(), "heal_a_petrock", AdvancementType.GOAL, true, true, false))
                    .parent(orderPetRock)
                    .addCriterion("make_kibble", inventoryChangedTrigger(PRItems.KIBBLE.get()))
                    .save(consumer, getSaveLoc("heal_a_petrok"));
        }

        protected static DisplayInfo makeRootInfo(Item icon, String blockToDisplay, Boolean isMineCraft) {
            return new DisplayInfo(new ItemStack(icon),
                    Component.translatable(title("root")),
                    Component.translatable(desc("root")),
                    Optional.of(getBackground(isMineCraft, blockToDisplay)),
                    AdvancementType.TASK, false ,false ,false);
        }

        protected static DisplayInfo info(Item icon, String advancemntName, AdvancementType advancementType, Boolean showToast, Boolean announceChat, Boolean shouldBeHidden) {
            return new DisplayInfo(new ItemStack(icon),
                    Component.translatable(title(advancemntName)),
                    Component.translatable(desc(advancemntName)),
                    Optional.empty(),
                    advancementType, showToast ,announceChat ,shouldBeHidden);
        }

        protected static Criterion<InventoryChangeTrigger.TriggerInstance> inventoryChangedTrigger(Item item) {
            return InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(item).build());
        }

        protected static Criterion<KilledTrigger.TriggerInstance> killEntityTrigger(EntityType entity) {
            return KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(entity));
        }

        private static String getSaveLoc(String saveLoc) {
            return RLHelper.location(saveLoc).toString();
        }
        private static String title(String name) {
            return "advancements.petrock." + name + ".title";
        }
        private static String desc(String name) {
            return "advancements.petrock." + name + ".description";
        }

        private static ResourceLocation getBackground(Boolean isMCBackground, String backgroundName) {
            if (isMCBackground) {
               return ResourceLocation.withDefaultNamespace("textures/block/" + backgroundName + ".png");
            }
            return RLHelper.location("textures/block/" + backgroundName + ".png");
        }
    }
}
