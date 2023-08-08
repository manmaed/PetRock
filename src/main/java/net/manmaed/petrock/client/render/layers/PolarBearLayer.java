package net.manmaed.petrock.client.render.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.manmaed.petrock.hats.PRHats;
import net.minecraft.client.model.PolarBearModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

/**
 * Created by manmaed on 24/01/2022.
 */
public class PolarBearLayer extends RenderLayer {

    private static final ResourceLocation skin = new ResourceLocation("minecraft", "textures/entity/bear/polarbear.png");
    private final PolarBearModel hat;
    private final BearLayer bearLayer;
    private final HoodLayer hoodLayer;

    public PolarBearLayer(RenderLayerParent layerParent, EntityModelSet entityModelSet) {
        super(layerParent);
        this.hat = new PolarBearModel(entityModelSet.bakeLayer(ModelLayers.POLAR_BEAR));
        bearLayer = new BearLayer(layerParent, entityModelSet);
        hoodLayer = new HoodLayer(layerParent, entityModelSet);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, Entity entity, float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {
        if(PRHats.bear) {
            poseStack.pushPose();
            poseStack.scale(0.5F, 0.5F, 0.5F);
            poseStack.translate(0F,0.375F,0F);
            VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(skin));
            hat.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            bearLayer.render(poseStack, multiBufferSource, packedLight, entity,  p_117353_, p_117354_, p_117355_, p_117356_, p_117357_, p_117358_);
            hoodLayer.render(poseStack, multiBufferSource, packedLight, entity,  p_117353_, p_117354_, p_117355_, p_117356_, p_117357_, p_117358_);
            poseStack.popPose();
        }
    }
}
