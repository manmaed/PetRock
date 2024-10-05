package net.manmaed.petrock.client.render.entity;


import net.manmaed.petrock.client.model.PRModels;
import net.manmaed.petrock.client.render.layers.*;
import net.manmaed.petrock.client.render.model.ModelPetRock;
import net.manmaed.petrock.entity.EntityPetRock;
import net.manmaed.petrock.libs.RLHelper;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

/**
 * Created by manmaed on 30/08/2019.
 */
public class RenderPetRock extends MobRenderer<EntityPetRock, ModelPetRock> {


    private static final ResourceLocation UNTAME = RLHelper.location("textures/entity/petrock.png");
    private static final ResourceLocation TAMED = RLHelper.location("textures/entity/petrock_tame.png");
    private static final ResourceLocation SITTING = RLHelper.location("textures/entity/petrocktamesit.png");

    public RenderPetRock(EntityRendererProvider.Context context) {
        super(context, new ModelPetRock(context.bakeLayer(PRModels.PETROCK)), 0.25F);
        this.addLayer(new BirthdayLayer(this, context.getModelSet()));
        this.addLayer(new ChristmasLayer(this, context.getModelSet()));
        this.addLayer(new HalloweenLayer(this, context.getModelSet()));
        this.addLayer(new SlowpokeLayer(this, context.getModelSet()));
        this.addLayer(new CageLayer(this, context.getModelSet()));
        this.addLayer(new SignLayer(this, context.getModelSet()));
        this.addLayer(new EggLayer(this, context.getModelSet()));
        this.addLayer(new PolarBearLayer(this, context.getModelSet()));
        this.addLayer(new TNTSidesLayer(this, context.getModelSet()));
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
