package net.manmaed.petrock.worldgen.ores;

/**
 * Created by manmaed on 09/06/2022.
 */

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;

/**
 *  Copy Paste form forge tests
 */
public record OreBiomeModifier(GenerationStep.Decoration generationStage, HolderSet<PlacedFeature> placedFeature) implements BiomeModifier {

    public static Codec<OreBiomeModifier> CODEC = RecordCodecBuilder.create(builder ->
            builder.group(
            Codec.STRING.comapFlatMap(OreBiomeModifier::generationStageFromString, GenerationStep.Decoration::toString).fieldOf("generation_stage").forGetter(OreBiomeModifier::generationStage),
            PlacedFeature.LIST_CODEC.fieldOf("features").forGetter(OreBiomeModifier::placedFeature)
    ).apply(builder, OreBiomeModifier::new));

    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase == Phase.ADD && (!biome.is(BiomeTags.IS_END) || !biome.is(BiomeTags.IS_NETHER))) {
            //System.out.println("Biome: " + !biome.is(BiomeTags.IS_NETHER));
            //System.out.println("Biome: " + !biome.is(BiomeTags.IS_END));
            BiomeGenerationSettingsBuilder generationSettings = builder.getGenerationSettings();
            this.placedFeature.forEach(placedFeatureHolder -> generationSettings.addFeature(this.generationStage, placedFeatureHolder));
        }
    }



    @Override
    public Codec<? extends BiomeModifier> codec() {
        return PROres.ORE_BIOME_MODIFIER.get();
    }

    private static DataResult<GenerationStep.Decoration> generationStageFromString(String name)
    {
        try
        {
            return DataResult.success(GenerationStep.Decoration.valueOf(name));
        }
        catch (Exception e)
        {
            return DataResult.error("Not a decoration stage: " + name);
        }
    }
}
