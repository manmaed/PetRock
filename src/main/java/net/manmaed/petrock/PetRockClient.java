package net.manmaed.petrock;

import net.manmaed.petrock.client.model.PRModels;
import net.manmaed.petrock.client.render.entity.RenderPetRock;
import net.manmaed.petrock.client.render.entity.RenderPetRockWithLegs;
import net.manmaed.petrock.client.render.model.*;
import net.manmaed.petrock.commands.PRCommands;
import net.manmaed.petrock.entity.PREntityTypes;
import net.manmaed.petrock.hats.PRHats;
import net.minecraft.client.Minecraft;
import net.neoforged.fml.ModList;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterClientCommandsEvent;

public class PetRockClient {

    public static boolean iChunHatsLoaded;
    public static String slow_uuid = "d2839efc727a426397ce3c73cdee5013";

    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(PRModels.PETROCK, ModelPetRock::createBodyLayer);
        event.registerLayerDefinition(PRModels.PETROCKWITHLEGS, ModelPetRockWithLegs::createBodyLayer);
        event.registerLayerDefinition(PRModels.CAKE, ModelCakeHat::createBodyLayer);
        event.registerLayerDefinition(PRModels.CREEPER, ModelCreeperHat::createBodyLayer);
        event.registerLayerDefinition(PRModels.SANTA, ModelSantaHat::createBodyLayer);
        event.registerLayerDefinition(PRModels.SLOWPOKE, ModelSlowpokeHat::createBodyLayer);
        event.registerLayerDefinition(PRModels.CAGE, ModelCageHat::createBodyLayer);
        event.registerLayerDefinition(PRModels.SIGN, ModelSignHat::createBodyLayer);
        event.registerLayerDefinition(PRModels.EASTER_EGG, ModelEggHat::createBodyLayer);
        event.registerLayerDefinition(PRModels.HOOD, ModelHood::createBodyLayer);
        event.registerLayerDefinition(PRModels.TNT_SIDE, ModelTNTSides::createBodyLayer);
        event.registerLayerDefinition(PRModels.TNT_TOP, ModelTNTTop::createBodyLayer);
        event.registerLayerDefinition(PRModels.TNT_BOTTOM, ModelTNTBottom::createBodyLayer);
    }

    public static void registerClientCommands(RegisterClientCommandsEvent event) {
        PRCommands.register(event.getDispatcher());
    }
    public static void doEntityRendering(final EntityRenderersEvent.RegisterRenderers event) {;
        event.registerEntityRenderer(PREntityTypes.PETROCK.get(), RenderPetRock::new);
        event.registerEntityRenderer(PREntityTypes.PETROCKWITHLEGS.get(), RenderPetRockWithLegs::new);
    }

    public static void doClientStuff(final FMLClientSetupEvent event) {
        String uuid = Minecraft.getInstance().getUser().getProfileId().toString().replace("-", "");
        iChunHatsLoaded = ModList.get().isLoaded("hats");
        if (!iChunHatsLoaded) {
            if (uuid.equals(slow_uuid)) {
                PRHats.slowIsPlaying();
            }
            new Thread(PRHats::load).start();
        }
    }


}