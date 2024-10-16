package net.manmaed.petrock.worldgen.ores;

import net.manmaed.petrock.libs.RLHelper;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class PRPlacedFeatures {
    protected static ResourceKey<PlacedFeature> ORE_STONEIUM = createKey("ore_stoneium");
    protected static ResourceKey<PlacedFeature> ORE_STONEIUM_LOWER = createKey("ore_stoneium_lower");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> featureHolder = configuredFeatures.getOrThrow(PRConfiguredFeatures.ORE_STONEIUM);
/*        Holder<ConfiguredFeature<?, ?>> featureHolder2 = configuredFeatures.getOrThrow(PRConfiguredFeatures.DEEP_OVERWORLD_ORES);*/

        PlacementUtils.register(context, ORE_STONEIUM, featureHolder, PROrePlacement.commonOrePlacements(5, HeightRangePlacement.triangle(VerticalAnchor.BOTTOM, VerticalAnchor.TOP)));
    }
    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> resourceKey, Holder<ConfiguredFeature<?, ?>> configuredFeatureHolder, List<PlacementModifier> placementModifiers) {
        context.register(resourceKey, new PlacedFeature(configuredFeatureHolder, placementModifiers));
    }
    private static ResourceKey<PlacedFeature> createKey(String name){
        return ResourceKey.create(Registries.PLACED_FEATURE, RLHelper.location(name));
    }
}
