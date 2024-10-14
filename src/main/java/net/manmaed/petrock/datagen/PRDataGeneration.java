package net.manmaed.petrock.datagen;

import net.manmaed.petrock.PetRock;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = PetRock.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PRDataGeneration {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        PRBlockTagsProvider prBlockTagsProvider = new PRBlockTagsProvider(packOutput, lookupProvider, fileHelper);

        generator.addProvider(true, new PRRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(true, prBlockTagsProvider);
        generator.addProvider(true, new PRItemTagsProvider(packOutput, lookupProvider, prBlockTagsProvider.contentsGetter(), fileHelper));
        generator.addProvider(true, new PRLootTabels(packOutput, lookupProvider));
        generator.addProvider(true, new PRWorldGenProvider(packOutput, lookupProvider));
        generator.addProvider(true, new PRAdvancementProvider(packOutput, lookupProvider, fileHelper));



    }
}
