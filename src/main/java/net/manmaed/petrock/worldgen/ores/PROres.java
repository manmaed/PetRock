package net.manmaed.petrock.worldgen.ores;

import net.manmaed.petrock.blocks.PRBlocks;
import net.manmaed.petrock.config.PRConfig;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;

/**
 * Created by manmaed on 25/01/2022.
 */
public class PROres {

    //TODO: move to configs

    public static PlacedFeature STONEIUM_ORE_GEN;

    public static void registerConfigerdFeatures() {
        OreConfiguration overworldConfig = new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES, PRBlocks.STONEIUM_ORE.get().defaultBlockState(), PRConfig.STONEIUM_ORE_VAIN_SIZE.get());
        STONEIUM_ORE_GEN = registerPlacedFeature("overworld_stoneium_ore", Feature.ORE.configured(overworldConfig),
                CountPlacement.of(PRConfig.STONEIUM_ORE_VAIN_AMOUNT.get()),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(90)));
    }
    private static <C extends FeatureConfiguration, F extends Feature<C>> PlacedFeature registerPlacedFeature(String registryName, ConfiguredFeature<C, F> feature, PlacementModifier... placementModifiers) {
        PlacedFeature placed = BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(registryName), feature).placed(placementModifiers);
        return PlacementUtils.register(registryName, placed);
    }

    public static void  onBiomeLoadingEvent(BiomeLoadingEvent event) {
        if(event.getCategory() == Biome.BiomeCategory.NETHER) {
            //Nether
        }
        if(event.getCategory() == Biome.BiomeCategory.THEEND) {
            //The End
        } else {
            //OverWorld
            if (PRConfig.ENABLE_WORLD_GEN.get()) {
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, STONEIUM_ORE_GEN);
            }
        }
    }


}
