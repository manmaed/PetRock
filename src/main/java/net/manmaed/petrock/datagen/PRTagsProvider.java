package net.manmaed.petrock.datagen;

import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.block.PRBlocks;
import net.manmaed.petrock.tag.PRTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class PRTagsProvider extends BlockTagsProvider {

    public PRTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, PetRock.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.STONE_ORE_REPLACEABLES).add(PRBlocks.STONEIUM_ORE.get());
        tag(BlockTags.DEEPSLATE_ORE_REPLACEABLES).add(PRBlocks.DEEPSLATE_STONEIUM_ORE.get());
        tag(PRTags.STONEIUM_ORES).add(PRBlocks.STONEIUM_ORE.get()).add(PRBlocks.DEEPSLATE_STONEIUM_ORE.get());
        tag(BlockTags.NEEDS_STONE_TOOL).add(PRBlocks.STONEIUM_ORE.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(PRBlocks.DEEPSLATE_STONEIUM_ORE.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(PRBlocks.STONEIUM_ORE.get()).add(PRBlocks.DEEPSLATE_STONEIUM_ORE.get());
    }
}
