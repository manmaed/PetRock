package net.manmaed.petrock.datagen;

import com.google.common.collect.ImmutableList;
import net.manmaed.petrock.block.PRBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class PRLootTabels extends LootTableProvider {
    protected PRLootTabels(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup) {
        super(packOutput, Set.of(), ImmutableList.of(new LootTableProvider.SubProviderEntry(PRBlockLoot::new, LootContextParamSets.BLOCK)), lookup);
    }

    public static class PRBlockLoot extends BlockLootSubProvider {
        protected PRBlockLoot(HolderLookup.Provider lookup) {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags(), lookup);
        }

        @Override
        protected void generate() {
            dropSelf(PRBlocks.STONEIUM_ORE.get());
            dropSelf(PRBlocks.DEEPSLATE_STONEIUM_ORE.get());
            dropSelf(PRBlocks.STONEIUM_BLOCK.get());
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            List<Block> blocks = new ArrayList<>();
            PRBlocks.BLOCKS.getEntries().stream().map(DeferredHolder::get).forEach((b) -> blocks.add(b.defaultBlockState().getBlock()));
            return blocks;
        }
    }
}
