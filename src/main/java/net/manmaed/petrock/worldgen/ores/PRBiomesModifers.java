package net.manmaed.petrock.worldgen.ores;

import net.manmaed.petrock.libs.RLHelper;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class PRBiomesModifers {

    private static ResourceKey<BiomeModifier> ADD_STONEIUM_ORE = createKey("add_stoneium_ore");
    private static ResourceKey<BiomeModifier> ADD_DEEPSLATE_STONEIUM_ORE = createKey("add_deepslate_stoneium_ore");

    private static ResourceKey<BiomeModifier> ORE_STONEIUM = createKey("ore_stoneium");



    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        HolderGetter<PlacedFeature> placedFeaturs = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        context.register(
                ORE_STONEIUM,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                        HolderSet.direct(placedFeaturs.getOrThrow(PRPlacedFeatures.ORE_STONEIUM)),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                        ));
        /*context.register(
                ADD_DEEPSLATE_STONEIUM_ORE,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                        HolderSet.direct(placedFeaturs.getOrThrow(PRPlacedFeatures.ORE_STONEIUM)),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                ));*/

    }

    private static ResourceKey<BiomeModifier> createKey(String name){
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, RLHelper.location(name));
    }
}
