package net.manmaed.petrock.worldgen.ores;

import net.manmaed.petrock.block.PRBlocks;
import net.manmaed.petrock.libs.RLHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class PRConfiguredFeatures {
    protected static ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ORES = createKey("overworld_ores");
    protected static ResourceKey<ConfiguredFeature<?, ?>> DEEP_OVERWORLD_ORES = createKey("deep_overworld_ores");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> stoneiumOre = List.of(OreConfiguration.target(stoneReplaceable, PRBlocks.STONEIUM_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> deepslateStoneiumOre = List.of(OreConfiguration.target(deepslateReplaceable, PRBlocks.DEEPSLATE_STONEIUM_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_ORES, Feature.ORE, new OreConfiguration(stoneiumOre, 6));
        register(context, DEEP_OVERWORLD_ORES, Feature.ORE, new OreConfiguration(deepslateStoneiumOre, 6));

    }

    private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name){
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, RLHelper.location(name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?,?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
