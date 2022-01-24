package net.manmaed.petrock.client.render.entity;


import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.client.model.PRModels;
import net.manmaed.petrock.client.render.layers.BirthdayFeatureRenderer;
import net.manmaed.petrock.client.render.model.ModelCakeHat;
import net.manmaed.petrock.client.render.model.ModelPetRock;
import net.manmaed.petrock.entitys.EntityPetRock;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

/**
 * Created by manmaed on 30/08/2019.
 */
public class RenderPetRock extends MobRenderer<EntityPetRock, ModelPetRock<EntityPetRock>> {

    private static final ResourceLocation UNTAME = new ResourceLocation(PetRock.MOD_ID, "textures/entity/petrock.png");
    private static final ResourceLocation TAMED = new ResourceLocation(PetRock.MOD_ID, "textures/entity/petrock_tame.png");
    private static final ResourceLocation SITTING = new ResourceLocation(PetRock.MOD_ID, "textures/entity/petrocktamesit.png");

    public RenderPetRock(EntityRendererProvider.Context context) {
        super(context, new ModelPetRock<EntityPetRock>(context.bakeLayer(PRModels.PETROCK)), 0.25F);

        //TODO: ReAdd layers
        this.addLayer(new BirthdayFeatureRenderer(this));
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
            if (petRock.isInSittingPose()) {
                return SITTING;
            } else {
                return TAMED;
            }
        } else {
            return UNTAME;
        }
    }
}
