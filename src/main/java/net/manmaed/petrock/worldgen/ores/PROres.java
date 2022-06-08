package net.manmaed.petrock.worldgen.ores;

import net.manmaed.petrock.blocks.PRBlocks;
import net.manmaed.petrock.config.PRConfig;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static net.minecraft.data.worldgen.features.OreFeatures.DEEPSLATE_ORE_REPLACEABLES;

/**
 * Created by manmaed on 25/01/2022.
 */
public class PROres {

    //todo: Fix
    public static final List<OreConfiguration.TargetBlockState> ORE_STONEIUM_TARGET_LIST;
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_STONEIUM_CONFIG;
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_STONEIUM_DEEPSLATE_CONFIG;
    public static final Holder<PlacedFeature> ORE_STONEIUM;
    public static final Holder<PlacedFeature> ORE_STONEIUM_DEEPSLATE;

    public static final Set<Holder<PlacedFeature>> PLACEMENTS = new HashSet<>();

    public static void init() {}

    static {
        ORE_STONEIUM_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, PRBlocks.STONEIUM_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, PRBlocks.DEEPSLATE_STONEIUM_ORE.get().defaultBlockState()));

        ORE_STONEIUM_CONFIG = FeatureUtils.register("ore_stoneium", Feature.ORE,
                new OreConfiguration(ORE_STONEIUM_TARGET_LIST, PRConfig.STONEIUM_ORE_VAIN_SIZE.get())); //PRConfig.STONEIUM_ORE_VAIN_SIZE.get() = 10
        ORE_STONEIUM_DEEPSLATE_CONFIG = FeatureUtils.register("ore_stoneium_deepslate", Feature.ORE,
                new OreConfiguration(ORE_STONEIUM_TARGET_LIST, PRConfig.DEEPSLATE_STONEIUM_ORE_VAIN_SIZE.get())); //PRConfig.DEEPSLATE_STONEIUM_ORE_VAIN_SIZE.get() = 10

        ORE_STONEIUM = PlacementUtils.register("ore_stoneium", ORE_STONEIUM_CONFIG, commonOrePlacement(
                PRConfig.STONEIUM_ORE_VAIN_AMOUNT.get(), //STONEIUM_ORE_VAIN_AMOUNT = 30
                HeightRangePlacement.triangle(
                        VerticalAnchor.absolute(30), VerticalAnchor.absolute(384)
                )));
        ORE_STONEIUM_DEEPSLATE = PlacementUtils.register("ore_stoneium_deepslate", ORE_STONEIUM_DEEPSLATE_CONFIG, commonOrePlacement(
                PRConfig.DEEPSLATE_STONEIUM_ORE_VAIN_AMOUNT.get(), //DEEPSLATE_STONEIUM_ORE_VAIN_AMOUNT = 15
                HeightRangePlacement.triangle(
                        VerticalAnchor.bottom(), VerticalAnchor.absolute(0)
                )));
        PLACEMENTS.addAll(List.of(ORE_STONEIUM, ORE_STONEIUM_DEEPSLATE));
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
                PROres.PLACEMENTS.forEach(e -> event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, e));
            }
        }
    }


}
