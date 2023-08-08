package net.manmaed.petrock;

import net.manmaed.petrock.block.PRBlocks;
import net.manmaed.petrock.config.PRConfig;
import net.manmaed.petrock.entity.EntityPetRock;
import net.manmaed.petrock.entity.EntityPetRockWithLegs;
import net.manmaed.petrock.entity.PREntityTypes;
import net.manmaed.petrock.hats.Trolling;
import net.manmaed.petrock.item.PRItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Calendar;

/**
 * Created by manmaed on 25/11/2019.
 */
@Mod(PetRock.MOD_ID)
public class PetRock {

    public static final String MOD_ID = "petrock";

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);
    public static final RegistryObject<CreativeModeTab> PR_TAB = CREATIVE_MODE_TABS.register(MOD_ID, () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(PRItems.PETROCKBOX.get()))
            .title(Component.translatable("itemGroup." + MOD_ID))
            .displayItems((parameters, output) -> {
                for (Item item : ForgeRegistries.ITEMS.getValues()) {
                    if (item.getCreatorModId(item.getDefaultInstance()).equals(MOD_ID)) {
                        output.accept(item);
                    }
                }
            })
            .build());

    public PetRock() {
        IEventBus event = FMLJavaModLoadingContext.get().getModEventBus();
        PRItems.ITEMS.register(event);
        PRBlocks.BLOCKS.register(event);
        CREATIVE_MODE_TABS.register(event);
        PREntityTypes.ENTITY_TYPES.register(event);
        event.addListener(this::AttributeCreation);
        event.addListener(PetRockClient::doEntityRendering);
        event.addListener(PetRockClient::registerLayerDefinitions);
        event.addListener(PetRockClient::doClientStuff);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, PRConfig.COMMON_CONFIG);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, PetRockClient::registerClientCommands);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, this::onPlayerJoinWorld);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, this::onPlayerLeaveWold);
    }

    public void onPlayerJoinWorld(PlayerEvent.PlayerLoggedInEvent event) {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        if (PRConfig.DISABLE_TROLL.get()) {
            if (month == Calendar.APRIL && day == 1 || PRConfig.IS_APRIL_FOOLS_EVERYDAY.get()) {
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

    public void onPlayerLeaveWold(PlayerEvent.PlayerLoggedOutEvent event) {
        Trolling.endTroll();
        /*LogHelper.info("Stopping Troll");*/
    }

    private void AttributeCreation(EntityAttributeCreationEvent event) {
        event.put(PREntityTypes.PETROCK.get(), EntityPetRock.createAttributes().build());
        event.put(PREntityTypes.PETROCKWITHLEGS.get(), EntityPetRockWithLegs.createAttributes().build());
    }
    /*    public PetRock() {
        PROres.FEATURE_REGISTRY.register(event);
        PROres.PLACED_FEATURE_REGISTRY.register(event);
        PROres.BIOME_SERIALIZERS.register(event);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, PRConfig.COMMON_CONFIG);

        *//*event.addListener(PetRockClient::onPlayerJoinWorld);
        event.addListener(PetRockClient::onPlayerLeaveWold);*//*
        event.addListener(this::init);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, this::onPlayerJoinWorld);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, this::onPlayerLeaveWold);

    }

    public static void disable_troll() {
        command_disabled_troll = true;
    }

    public static boolean hascommadbeenused() {
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
        *//*LogHelper.info("Stopping Troll");*//*
    }*/
}
