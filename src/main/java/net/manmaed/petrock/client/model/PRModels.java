package net.manmaed.petrock.client.model;

import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.client.render.model.ModelPetRock;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;

/**
 * Created by manmaed on 17/12/2021.
 */
public class PRModels {

    public static final ModelLayerLocation PETROCK = makeModelLayerLocation("petrock");

    //Layers
    public static final ModelLayerLocation CAKE = makeModelLayerLocation("cake");

    /*public static final ModelLayerLocation PETROCK = new ModelLayerLocation(new ResourceLocation(PetRock.MOD_ID, "petrock"), "petrock");*/



    public static ModelLayerLocation makeModelLayerLocation(String name) {
        return new ModelLayerLocation(new ResourceLocation(PetRock.MOD_ID, name), name);
    }

}
