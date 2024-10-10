package net.manmaed.petrock.datagen;

import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.worldgen.ores.PRBiomesModifers;
import net.manmaed.petrock.worldgen.ores.PRConfiguredFeatures;
import net.manmaed.petrock.worldgen.ores.PRPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class PRWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public PRWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture, new RegistrySetBuilder()
                .add(Registries.CONFIGURED_FEATURE, PRConfiguredFeatures::bootstrap)
                .add(Registries.PLACED_FEATURE, PRPlacedFeatures::bootstrap)
                .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, PRBiomesModifers::bootstrap),
                Set.of(PetRock.MOD_ID));
    }
}
