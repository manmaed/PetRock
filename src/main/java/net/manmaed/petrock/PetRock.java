package net.manmaed.petrock;

import net.manmaed.petrock.blocks.PRBlocks;
import net.manmaed.petrock.commands.PRCommands;
import net.manmaed.petrock.config.PRConfig;
import net.manmaed.petrock.entitys.EntityPetRock;
import net.manmaed.petrock.entitys.PREntityTypes;
import net.manmaed.petrock.items.PRItems;
import net.manmaed.petrock.worldgen.ores.PROres;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * Created by manmaed on 25/11/2019.
 */
@Mod(PetRock.MOD_ID)
public class PetRock {

    /*
    TODO: World Generation
    TODO: World Generation Config
     */
    public static final String MOD_ID = "petrock";
    public static final CreativeModeTab itemGroup = new CreativeModeTab(PetRock.MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(PRItems.PETROCKBOX.get());
        }
    };

    public PetRock() {
        IEventBus event = FMLJavaModLoadingContext.get().getModEventBus();
        PRItems.ITEMS.register(event);
        PRBlocks.BLOCKS.register(event);
        PREntityTypes.ENTITY_TYPES.register(event);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, PRConfig.COMMON_CONFIG);

        event.addListener(this::AttributeCreation);
        event.addListener(PetRockClient::doEntityRendering);
        event.addListener(PetRockClient::registerLayerDefinitions);
        event.addListener(PetRockClient::doClientStuff);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, PROres::onBiomeLoadingEvent);
        event.addListener(this::init);
    }

    public void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(PROres::registerConfigerdFeatures);
    }

    private void AttributeCreation(EntityAttributeCreationEvent event) {
        event.put(PREntityTypes.PETROCK.get(), EntityPetRock.createAttributes().build());
    }

    private void serverLoad(ServerStartedEvent event) {
        PRCommands.register(event.getServer().getCommands().getDispatcher());
    }
}
