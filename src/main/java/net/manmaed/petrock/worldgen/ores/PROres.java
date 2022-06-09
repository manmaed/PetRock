package net.manmaed.petrock.worldgen.ores;

import com.mojang.serialization.Codec;
import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.blocks.PRBlocks;
import net.manmaed.petrock.config.PRConfig;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
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
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.checkerframework.checker.units.qual.C;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import static net.minecraft.data.worldgen.features.OreFeatures.DEEPSLATE_ORE_REPLACEABLES;

/**
 * Created by manmaed on 25/01/2022.
 */
public class PROres {

    public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, PetRock.MOD_ID);
    public static final RegistryObject<Codec<OreBiomeModifier>> ORE_BIOME_MODIFIER = BIOME_SERIALIZERS.register("ore_biome_modifiers", () -> OreBiomeModifier.CODEC);


    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_STONEIUM_CONFIG;
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_STONEIUM_DEEPSLATE_CONFIG;
    public static final RegistryObject<PlacedFeature> ORE_STONEIUM;
    public static final RegistryObject<PlacedFeature> ORE_STONEIUM_DEEPSLATE;

    public static final Set<RegistryObject<PlacedFeature>> PLACEMENTS = new HashSet<>();

    public static final DeferredRegister<ConfiguredFeature<?, ?>> FEATURE_REGISTRY = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, PetRock.MOD_ID);
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURE_REGISTRY = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, PetRock.MOD_ID);

    public static void init() {}

    static {
        Supplier<List<OreConfiguration.TargetBlockState>> stoneiumTargetList = () -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, PRBlocks.STONEIUM_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, PRBlocks.DEEPSLATE_STONEIUM_ORE.get().defaultBlockState()));

        ORE_STONEIUM_CONFIG = FEATURE_REGISTRY.register("ore_stoneium", () -> new ConfiguredFeature<>(Feature.ORE,
                new OreConfiguration(stoneiumTargetList.get(), PRConfig.STONEIUM_ORE_VAIN_SIZE.get()))); //PRConfig.STONEIUM_ORE_VAIN_SIZE.get() = 10
        ORE_STONEIUM_DEEPSLATE_CONFIG = FEATURE_REGISTRY.register("ore_stoneium_deepslate", () -> new ConfiguredFeature<>(Feature.ORE,
                new OreConfiguration(stoneiumTargetList.get(), PRConfig.DEEPSLATE_STONEIUM_ORE_VAIN_SIZE.get()))); //PRConfig.DEEPSLATE_STONEIUM_ORE_VAIN_SIZE.get() = 10

        ORE_STONEIUM = PLACED_FEATURE_REGISTRY.register("ore_stoneium", () -> new PlacedFeature(ORE_STONEIUM_CONFIG.getHolder().get(), commonOrePlacement(
                PRConfig.STONEIUM_ORE_VAIN_AMOUNT.get(), //STONEIUM_ORE_VAIN_AMOUNT = 30
                HeightRangePlacement.triangle(
                        VerticalAnchor.absolute(30), VerticalAnchor.absolute(384)
                ))));
        ORE_STONEIUM_DEEPSLATE = PLACED_FEATURE_REGISTRY.register("ore_stoneium_deepslate", () -> new PlacedFeature(ORE_STONEIUM_DEEPSLATE_CONFIG.getHolder().get(), commonOrePlacement(
                PRConfig.DEEPSLATE_STONEIUM_ORE_VAIN_AMOUNT.get(), //DEEPSLATE_STONEIUM_ORE_VAIN_AMOUNT = 15
                HeightRangePlacement.triangle(
                        VerticalAnchor.bottom(), VerticalAnchor.absolute(0)
                ))));

        PLACEMENTS.addAll(List.of(ORE_STONEIUM, ORE_STONEIUM_DEEPSLATE));
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier placementModifier, PlacementModifier placementModifier2) {
        return List.of(placementModifier, InSquarePlacement.spread(), placementModifier2, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int amount, PlacementModifier placementModifier) {
        return orePlacement(CountPlacement.of(amount), placementModifier);
    }

}
