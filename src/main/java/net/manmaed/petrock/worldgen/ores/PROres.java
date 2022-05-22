package net.manmaed.petrock.worldgen.ores;

import net.manmaed.petrock.blocks.PRBlocks;
import net.manmaed.petrock.config.PRConfig;
import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import org.checkerframework.checker.units.qual.C;

import java.util.List;

import static net.minecraft.data.worldgen.features.OreFeatures.DEEPSLATE_ORE_REPLACEABLES;

/**
 * Created by manmaed on 25/01/2022.
 */
public class PROres {

    //TODO: move to configs

    public static final List<OreConfiguration.TargetBlockState> ORE_STONEIUM_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, PRBlocks.STONEIUM_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, PRBlocks.DEEPSLATE_STONEIUM_ORE.get().defaultBlockState()));
    public static Holder<ConfiguredFeature<OreConfiguration, ?>> FEATURE_ORE_STONEIUM;
    public static Holder<ConfiguredFeature<OreConfiguration, ?>> FEATURE_ORE_STONEIUM_DEEPSLATE;
    public static Holder<PlacedFeature> ORE_STONEIUM;
    public static Holder<PlacedFeature> ORE_STONEIUM_DEEPSLATE;

    public static void registerConfigerdFeatures() {

        FEATURE_ORE_STONEIUM = FeatureUtils.register("ore_stoneium", Feature.ORE,
                new OreConfiguration(ORE_STONEIUM_TARGET_LIST, PRConfig.STONEIUM_ORE_VAIN_SIZE.get()));
        FEATURE_ORE_STONEIUM_DEEPSLATE = FeatureUtils.register("ore_stoneium_deepslate", Feature.ORE,
                new OreConfiguration(ORE_STONEIUM_TARGET_LIST, PRConfig.DEEPSLATE_STONEIUM_ORE_VAIN_SIZE.get()));

        //COAL place Uper 30 LOWER 20 - CF-17
        //STONEIUM_ORE_VAIN_SIZE 10 - STONEIUM_ORE_VAIN_AMOUNT 20
        //DEEPSLATE_STONEIUM_ORE_VAIN_SIZE 10 - DEEPSLATE_STONEIUM_ORE_VAIN_AMOUNT 15
        ORE_STONEIUM = PlacementUtils.register("ore_stoneium", FEATURE_ORE_STONEIUM, commonOrePlacement(
                PRConfig.STONEIUM_ORE_VAIN_AMOUNT.get(),
                HeightRangePlacement.uniform(
                        VerticalAnchor.absolute(136), VerticalAnchor.top()
                )));
        ORE_STONEIUM_DEEPSLATE = PlacementUtils.register("ore_stoneium_deepslate", FEATURE_ORE_STONEIUM_DEEPSLATE, commonOrePlacement(
                        PRConfig.DEEPSLATE_STONEIUM_ORE_VAIN_AMOUNT.get(),
                HeightRangePlacement.uniform(
                        VerticalAnchor.bottom(), VerticalAnchor.absolute(0)
                )));


    }

    private static List<PlacementModifier> orePlacement(PlacementModifier placementModifier, PlacementModifier placementModifier2) {
        return List.of(placementModifier, InSquarePlacement.spread(), placementModifier2, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int amount, PlacementModifier placementModifier) {
        return orePlacement(CountPlacement.of(amount), placementModifier);
    }

    public static void onBiomeLoadingEvent(BiomeLoadingEvent event) {
        if(event.getCategory() == Biome.BiomeCategory.NETHER) {
            //Nether
        }
        if(event.getCategory() == Biome.BiomeCategory.THEEND) {
            //The End
        } else {
            //OverWorld
            if (PRConfig.ENABLE_WORLD_GEN.get()) {
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_STONEIUM);
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_STONEIUM_DEEPSLATE);
            }
        }
    }


}
