package net.manmaed.petrock.client.render.entity;


import com.mojang.blaze3d.vertex.PoseStack;
import net.manmaed.petrock.client.model.PRModels;
import net.manmaed.petrock.client.render.layers.MiniSlowpokeLayer;
import net.manmaed.petrock.client.render.model.ModelPetRockWithLegs;
import net.manmaed.petrock.entity.EntityPetRockWithLegs;
import net.manmaed.petrock.libs.RLHelper;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

/**
 * Created by manmaed on 30/08/2019.
 */
public class RenderPetRockWithLegs extends MobRenderer<EntityPetRockWithLegs, ModelPetRockWithLegs> {

    private static final ResourceLocation UNTAME = RLHelper.location("textures/entity/petrock_withlegs.png");
    private static final ResourceLocation TAMED = RLHelper.location("textures/entity/petrock_withlegs_tame.png");
    private static final ResourceLocation SITTING = RLHelper.location("textures/entity/petrock_withlegs_tamesit.png");

    public RenderPetRockWithLegs(EntityRendererProvider.Context context) {
        super(context, new ModelPetRockWithLegs(context.bakeLayer(PRModels.PETROCKWITHLEGS)), 0.25F);
        this.addLayer(new MiniSlowpokeLayer(this, context.getModelSet()));
    }

    @Override
    public void render(EntityPetRockWithLegs entity, float f1, float f2, PoseStack poseStack, MultiBufferSource multiBufferSource, int i1) {
        poseStack.pushPose();
        if (entity.isInSittingPose()) {
            poseStack.translate(0F, -0.25F, 0F);
            super.render(entity, f1, f2, poseStack, multiBufferSource, i1);
        } else {
            super.render(entity, f1, f2, poseStack, multiBufferSource, i1);
        }
        poseStack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(EntityPetRockWithLegs petRock) {
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
