package net.manmaed.petrock.datagen;

import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.item.PRItems;
import net.manmaed.petrock.tag.PRTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class PRItemTagsProvider extends ItemTagsProvider {
    public PRItemTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture, CompletableFuture<TagsProvider.TagLookup<Block>> blockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, blockTagsProvider, PetRock.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider context) {
        tag(Tags.Items.RAW_MATERIALS).addTag(PRTags.RAW_MATERIALS_STONEIUM);
        tag(PRTags.RAW_MATERIALS_STONEIUM).add(PRItems.RAW_STONEIUM.get());
    }
}
