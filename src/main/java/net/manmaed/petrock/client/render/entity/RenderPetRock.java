package net.manmaed.petrock.client.render.entity;


import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.client.render.layers.*;
import net.manmaed.petrock.client.render.model.ModelPetRock;
import net.manmaed.petrock.entitys.EntityPetRock;
import net.manmaed.petrock.libs.Refs;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ResourceLocation;

/**
 * Created by manmaed on 30/08/2019.
 */
public class RenderPetRock extends MobRenderer<EntityPetRock, ModelPetRock<EntityPetRock>> {

    private static final ResourceLocation skinuntame = new ResourceLocation(PetRock.MOD_ID, "textures/entity/petrock.png");
    private static final ResourceLocation skintame = new ResourceLocation(PetRock.MOD_ID, "textures/entity/petrock_tame.png");
    private static final ResourceLocation skintamesit = new ResourceLocation(PetRock.MOD_ID, "textures/entity/petrocktamesit.png");

    //TODO: Fix this
    public RenderPetRock(EntityRendererProvider.Context context) {
        super(context, new ModelPetRock<>(context.bakeLayer(this))), 0.25F);

        //TODO: ReAdd layers
        /*this.addLayer(new BirthdayFeatureRenderer(this));
        this.addLayer(new ChristmasFeatureRenderer(this));
        this.addLayer(new HalloweenFeatureRenderer(this));
        this.addLayer(new SlowpokeFeatureRenderer(this));
        this.addLayer(new CageFeatureRenderer(this));
        this.addLayer(new SignFeatureRenderer(this));*/
    }

    @Override
    public ResourceLocation getTextureLocation(EntityPetRock petRock) {
        if (petRock.isTame()) {
            if (petRock.isOrderedToSit()) {
                return skintamesit;
            } else {
                return skintame;
            }
        } else {
            return skinuntame;
        }
    }
}
