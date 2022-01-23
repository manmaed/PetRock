package net.manmaed.petrock;

import net.manmaed.petrock.client.render.entity.RenderPetRock;
import net.manmaed.petrock.entitys.PREntityTypes;
import net.manmaed.petrock.hats.PRHats;
import net.manmaed.petrock.hats.PRPHats;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class PetRockClient {

    public static String slow_uuid = "d2839efc727a426397ce3c73cdee5013";



    public static void doClientStuff(final FMLClientSetupEvent event) {
       //TODO: ReAdd Hat Stuff
        /*
         if(Minecraft.getInstance().getUser().getUuid().replace("-","").equals(slow_uuid)){
            PRHats.slowisplaying();
        }
        ClientRegistry.registerEntityShader(PREntityTypes.PETROCK.get(), new RenderPetRock());
        ClientRegistry.registerEntityShader(PREntityTypes.PETROCK.get());
        RenderingRegistry.registerEntityRenderingHandler(PREntityTypes.PETROCK.get(), RenderPetRock::new);
         * LatvianModder Improved!
        if (ModList.get().isLoaded("hats")) {
           PetRock.setHatsLoaded();
        }
        new Thread(PRHats::load).start();
        new Thread(PRPHats::load).start();*/
        EntityRenderers.register(PREntityTypes.PETROCK.get(), RenderPetRock::new);
    }

    /*@OnlyIn(Dist.CLIENT)
    public static void doPlayerStuff(RenderPlayerEvent event) {
        event.getRenderer().addLayer(new PetRockFeatureRenderer(event.getRenderer()));
    }*/
}
