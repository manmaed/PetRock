package net.manmaed.petrock;

import net.manmaed.petrock.hats.PRHats;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class PetRockClient {

    public static String slow_uuid = "d2839efc727a426397ce3c73cdee5013";



    public static void doClientStuff(final FMLClientSetupEvent event) {
        if(Minecraft.getInstance().getUser().getUuid().replace("-","").equals(slow_uuid)){
            PRHats.slowisplaying();
        }
        /*ClientRegistry.registerEntityShader(PREntityTypes.PETROCK.get());*/
        /*RenderingRegistry.registerEntityRenderingHandler(PREntityTypes.PETROCK.get(), RenderPetRock::new);*/
        /*
         * LatvianModder Improved!
         */
        if (ModList.get().isLoaded("hats")) {
           PetRock.setHatsLoaded();
        }
        new Thread(PRHats::load).start();
        /*new Thread(PRPHats::load).start();*/
    }

    /*@OnlyIn(Dist.CLIENT)
    public static void doPlayerStuff(RenderPlayerEvent event) {
        event.getRenderer().addLayer(new PetRockFeatureRenderer(event.getRenderer()));
    }*/
}
