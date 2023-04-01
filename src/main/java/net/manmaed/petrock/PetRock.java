package net.manmaed.petrock;

import net.manmaed.petrock.blocks.PRBlocks;
import net.manmaed.petrock.commands.PRCommands;
import net.manmaed.petrock.config.PRConfig;
import net.manmaed.petrock.entitys.EntityPetRock;
import net.manmaed.petrock.entitys.EntityPetRockWithLegs;
import net.manmaed.petrock.entitys.PREntityTypes;
import net.manmaed.petrock.hats.Trolling;
import net.manmaed.petrock.items.PRItems;
import net.manmaed.petrock.libs.LogHelper;
import net.manmaed.petrock.worldgen.ores.PROres;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.Calendar;

/**
 * Created by manmaed on 25/11/2019.
 */
@Mod(PetRock.MOD_ID)
public class PetRock {

    public static final String MOD_ID = "petrock";
    private static Boolean command_disabled_troll = false;
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
        PROres.FEATURE_REGISTRY.register(event);
        PROres.PLACED_FEATURE_REGISTRY.register(event);
        PROres.BIOME_SERIALIZERS.register(event);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, PRConfig.COMMON_CONFIG);

        event.addListener(this::AttributeCreation);
        event.addListener(PetRockClient::doEntityRendering);
        event.addListener(PetRockClient::registerLayerDefinitions);
        event.addListener(PetRockClient::doClientStuff);
        /*event.addListener(PetRockClient::onPlayerJoinWorld);
        event.addListener(PetRockClient::onPlayerLeaveWold);*/
        event.addListener(this::init);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, this::onPlayerJoinWorld);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, this::onPlayerLeaveWold);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, this::registerCommands);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, PetRockClient::registerClientCommands);
    }

    public static void disable_troll() {
        command_disabled_troll = true;
    }

    public static Boolean hascommadbeenused() {
        return command_disabled_troll;
    }

    public void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(PROres::init);
        if (ModList.get().isLoaded("chancecubes")) {
            Trolling.CCEnable();
        }
    }

    public void registerCommands(RegisterCommandsEvent event) {
        PRCommands.registerNomal(event.getDispatcher());
    }

    private void AttributeCreation(EntityAttributeCreationEvent event) {
        event.put(PREntityTypes.PETROCK.get(), EntityPetRock.createAttributes().build());
        event.put(PREntityTypes.PETROCKWITHLEGS.get(), EntityPetRockWithLegs.createAttributes().build());
    }

    public void onPlayerJoinWorld(PlayerEvent.PlayerLoggedInEvent event) {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        if (!PRConfig.DISABLE_TROLL.get()) {
           if (!command_disabled_troll) {
                if (month == Calendar.APRIL && day == 1) {
                    if (!Trolling.isRunning()) {
                        Thread troll = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Trolling.startTroll(event);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        });
                        troll.start();
                    }
                }
            }
        }
    }

    public void onPlayerLeaveWold(PlayerEvent.PlayerLoggedOutEvent event) {
        Trolling.endTroll();
        /*LogHelper.info("Stopping Troll");*/
    }
}
