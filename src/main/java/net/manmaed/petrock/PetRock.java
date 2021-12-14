package net.manmaed.petrock;

import net.manmaed.petrock.blocks.PRBlocks;
import net.manmaed.petrock.config.PRConfig;
import net.manmaed.petrock.entitys.EntityPetRock;
import net.manmaed.petrock.entitys.PREntityTypes;
import net.manmaed.petrock.items.PRItems;
import net.manmaed.petrock.worldgen.WorldGenHandler;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.openjdk.nashorn.internal.objects.Global;

/**
 * Created by manmaed on 25/11/2019.
 */
@Mod(PetRock.MOD_ID)
public class PetRock {

    /*
    TODO: Entity Rendering
    TODO: Entity Hat Rendering
    TODO: World Generation
    TODO: World Generation Config
     */
    public static final String MOD_ID = "petrock";
    private static boolean ishatsloaded = false;
    public static final CreativeModeTab itemGroup = new CreativeModeTab(PetRock.MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(PRItems.PETROCKBOX.get());
        }
    };

    public static boolean getHatsLoaded() {
        return ishatsloaded;
    }
    public static void setHatsLoaded() {
        ishatsloaded = true;
    }

    public PetRock() {
        IEventBus event = FMLJavaModLoadingContext.get().getModEventBus();
        PRItems.ITEMS.register(event);
        PRBlocks.BLOCKS.register(event);
        PREntityTypes.ENTITY_TYPES.register(event);

        event.addListener(this::AttributeCreation);
        /*PRBlocks.FEATURES.register(event);

        event.addListener(this::init);
        event.addListener(PetRockClient::doClientStuff);

        PREntityTypes.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
            MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, PetRockClient::doPlayerStuff);
        });
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, PRConfig.COMMON_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, PRConfig.CLIENT_CONFIG);
        MinecraftForge.EVENT_BUS.addListener(this::serverLoad);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, WorldGenHandler::addStuffToBiomes);*/
    }

    private void AttributeCreation(EntityAttributeCreationEvent event) {
        event.put(PREntityTypes.PETROCK.get(), EntityPetRock.createAttributes().build());
    }

    /*private void init(final FMLCommonSetupEvent event) {*/
        // some preinit code;
        /*DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(PREntityTypes.PETROCK.get(), EntityPetRock.setCustomAttributes().create());
        });*/
        /*event.enqueueWork(WorldGenHandler::registerConfiguredFeatures);*/
    /*}*/


    /*private void serverLoad(ServerStartedEvent event) {
        PRCommands.register(event.getServer().getCommandManager().getDispatcher());
    }*/
}
