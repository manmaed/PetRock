package net.manmaed.petrock;

public class PetRockClient {

    public static String slow_uuid = "d2839efc727a426397ce3c73cdee5013";

    /*public static void doClientStuff(final FMLClientSetupEvent event) {
        if(Minecraft.getInstance().getSession().getPlayerID().replace("-","").equals(slow_uuid)){
            PRHats.slowisplaying();
        }
        RenderingRegistry.registerEntityRenderingHandler(PREntityTypes.PETROCK.get(), RenderPetRock::new);
        *//*
         * LatvianModder Improved!
         *//*
        if (ModList.get().isLoaded("hats")) {
           PetRock.setHatsLoaded();
        }
        new Thread(PRHats::load).start();
        *//*new Thread(PRPHats::load).start();*//*

    }*/

    /*@OnlyIn(Dist.CLIENT)
    public static void doPlayerStuff(RenderPlayerEvent event) {
        event.getRenderer().addLayer(new PetRockFeatureRenderer(event.getRenderer()));
    }*/
}
