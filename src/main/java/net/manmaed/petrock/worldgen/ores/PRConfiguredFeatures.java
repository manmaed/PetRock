package net.manmaed.petrock.worldgen.ores;

import net.manmaed.petrock.block.PRBlocks;
import net.manmaed.petrock.libs.RLHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class PRConfiguredFeatures {
/*
    protected static ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ORES = createKey("overworld_ores");
    protected static ResourceKey<ConfiguredFeature<?, ?>> DEEP_OVERWORLD_ORES = createKey("deep_overworld_ores");
*/

    protected static ResourceKey<ConfiguredFeature<?, ?>> ORE_STONEIUM = createKey("ore_stoneium");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> list_of_stoneium = List.of(
                OreConfiguration.target(stoneReplaceable, PRBlocks.STONEIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, PRBlocks.DEEPSLATE_STONEIUM_ORE.get().defaultBlockState())
        );

        FeatureUtils.register(context, ORE_STONEIUM, Feature.ORE, new OreConfiguration(list_of_stoneium, 17));

    }

    private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name){
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, RLHelper.location(name));
    }
}
