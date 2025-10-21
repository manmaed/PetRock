package net.manmaed.petrock.datagen;

import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.item.PRItems;
import net.manmaed.petrock.tag.PRTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import java.util.concurrent.CompletableFuture;

public class PRItemTagsProvider extends ItemTagsProvider {
    public PRItemTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture, CompletableFuture<TagsProvider.TagLookup<Block>> blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, blockTagsProvider, PetRock.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider context) {
        tag(Tags.Items.RAW_MATERIALS).addTag(PRTags.RAW_MATERIALS_STONEIUM);
        tag(PRTags.RAW_MATERIALS_STONEIUM).add(PRItems.RAW_STONEIUM.get());
        tag(PRTags.PETROCK_FOOD).add(PRItems.KIBBLE.get());

        tag(PRTags.PETROCK_STONE_VARIANT).add(Blocks.STONE.asItem());
        tag(PRTags.PETROCK_NETHER_VARIANT).add(Blocks.NETHERRACK.asItem());
        tag(PRTags.PETROCK_END_VARIANT).add(Blocks.END_STONE.asItem());
        tag(PRTags.PETROCK_DEEPSLATE_VARIANT).add(Blocks.DEEPSLATE.asItem());
        tag(PRTags.PETROCK_DIORITE_VARIANT).add(Blocks.DIORITE.asItem());
        tag(PRTags.PETROCK_GRANITE_VARIANT).add(Blocks.GRANITE.asItem());
        tag(PRTags.PETROCK_ANDASITE_VARIANT).add(Blocks.ANDESITE.asItem());
        tag(PRTags.PETROCK_CLAY_VARIANT).add(Blocks.CLAY.asItem());
        tag(PRTags.PETROCK_BEDROCK_VARIANT).add(Blocks.BEDROCK.asItem());
        tag(PRTags.PETROCK_MISSINGNO_VARIANT).add(PRItems.MISSING_NO.get());
    }
}
