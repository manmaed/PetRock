package net.manmaed.petrock;


import net.manmaed.petrock.blocks.PRBlocks;
import net.manmaed.petrock.client.model.PRModels;
import net.manmaed.petrock.client.render.entity.RenderPetRock;
import net.manmaed.petrock.client.render.model.*;
import net.manmaed.petrock.commands.PRCommands;
import net.manmaed.petrock.entitys.PREntityTypes;
import net.manmaed.petrock.hats.PRHats;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class PetRockClient {

    public static String slow_uuid = "d2839efc727a426397ce3c73cdee5013";
    public static boolean iChunHatsLoaded;

    public static void doEntityRendering(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(PREntityTypes.PETROCK.get(), RenderPetRock::new);
    }

    public static void registerClientCommands(RegisterClientCommandsEvent event) {
        PRCommands.register(event.getDispatcher());
    }

    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(PRModels.PETROCK, ModelPetRock::createBodyLayer);
        event.registerLayerDefinition(PRModels.CAKE, ModelCakeHat::createBodyLayer);
        event.registerLayerDefinition(PRModels.CREEPER, ModelCreeperHat::createBodyLayer);
        event.registerLayerDefinition(PRModels.SANTA, ModelSantaHat::createBodyLayer);
        event.registerLayerDefinition(PRModels.SLOWPOKE, ModelSlowpokeHat::createBodyLayer);
        event.registerLayerDefinition(PRModels.CAGE, ModelCageHat::createBodyLayer);
        event.registerLayerDefinition(PRModels.SIGN, ModelSignHat::createBodyLayer);


    }

    public static void doClientStuff(final FMLClientSetupEvent event) {
        String uuid = Minecraft.getInstance().getUser().getUuid().replace("-", "");
        iChunHatsLoaded = ModList.get().isLoaded("hats");
        if (!iChunHatsLoaded) {
            if (uuid.equals(slow_uuid)) {
                PRHats.slowisplaying();
            }
            new Thread(PRHats::load).start();
        }
    }
}