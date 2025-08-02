package net.manmaed.petrock.datagen;

import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.block.PRBlocks;
import net.manmaed.petrock.item.PRItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Objects;

public class PRItemModelProvider extends ItemModelProvider {
    public PRItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PetRock.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        handheldItem(PRItems.STONEIUM.get());
        handheldItem(PRItems.KIBBLE.get());
        handheldItem(PRItems.ORDER_FORM.get());
        handheldItem(PRItems.PETROCKBOX.get());
        handheldItem(PRItems.PETROCKWITHLEGSBOX.get(), "petrock_box");
        handheldItem(PRItems.STONE_LEGS.get());
        handheldItem(PRItems.RAW_STONEIUM.get());
        handheldItem(PRItems.ULTIMATE_STONEIUM.get(), "stoneium");

        makeBlockItem(PRBlocks.STONEIUM_BLOCK.get());
        makeBlockItem(PRBlocks.STONEIUM_ORE.get());
        makeBlockItem(PRBlocks.DEEPSLATE_STONEIUM_ORE.get());
    }

    private ResourceLocation getLoc(String loc) {
        return ResourceLocation.fromNamespaceAndPath(PetRock.MOD_ID, loc);
    }
    public ItemModelBuilder makeBlockItem(Block item) {
        return makeBlockItem(Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(item)));
    }

    public ItemModelBuilder makeBlockItem(ResourceLocation item) {
        return getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("petrock:block/" + item.getPath()));
    }

    public ItemModelBuilder handheldItem(Item item) {
        return handheldItem(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)));
    }

    public ItemModelBuilder handheldItem(Item item, String texture) {
        return handheldItem(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)), texture);
    }

    public ItemModelBuilder handheldItem(ResourceLocation item) {
        return getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath()));
    }

    public ItemModelBuilder handheldItem(ResourceLocation item, String texture) {
        return getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + texture));
    }
}
