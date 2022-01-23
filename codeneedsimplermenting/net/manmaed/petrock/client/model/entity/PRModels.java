package net.manmaed.petrock.client.model.entity;

import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.client.render.model.ModelPetRock;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;

/**
 * Created by manmaed on 17/12/2021.
 */
public class PRModels {

    public static ModelLayerLocation PETROCK = makeModelLayerLocation("petrock");

    public static ModelLayerLocation makeModelLayerLocation(String name) {
        return new ModelLayerLocation(new ResourceLocation(PetRock.MOD_ID, "model_" + name), name);
    }

    public static void load(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(PETROCK, ModelPetRock::createBodyLayer);
    }

}
