package net.manmaed.petrock.client.render.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.manmaed.petrock.client.model.PRModels;
import net.manmaed.petrock.client.render.model.ModelTNTSides;
import net.manmaed.petrock.hats.PRHats;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class TNTSidesLayer extends RenderLayer {

    private static final ResourceLocation skin = new ResourceLocation("minecraft", "textures/block/tnt_side.png");
    private final ModelTNTSides sides;
    private final TNTTopLayer top;
    private final TNTBottomLayer bottom;
    private final TNTPrimedLayer primed;

    public TNTSidesLayer(RenderLayerParent layerParent, EntityModelSet modelSet) {
        super(layerParent);
        this.sides = new ModelTNTSides(modelSet.bakeLayer(PRModels.TNT_SIDE));
        this.top = new TNTTopLayer(layerParent, modelSet);
        this.bottom = new TNTBottomLayer(layerParent, modelSet);
        this.primed = new TNTPrimedLayer(layerParent, modelSet);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, Entity entity, float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {
        if (PRHats.tnt) {
            poseStack.pushPose();
            poseStack.scale(0.25F, 0.25F, 0.25F);
            if(PRHats.slowpoke) {
                poseStack.translate(0F, -1.25F, 0.3F);
            } else {
                poseStack.translate(0F, 2.25F, 0F);
            }
            VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityCutout(skin));
            sides.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            top.render(poseStack, multiBufferSource, packedLight, entity,  p_117353_, p_117354_, p_117355_, p_117356_, p_117357_, p_117358_);
            bottom.render(poseStack, multiBufferSource, packedLight, entity,  p_117353_, p_117354_, p_117355_, p_117356_, p_117357_, p_117358_);
            primed.render(poseStack, multiBufferSource, packedLight, entity,  p_117353_, p_117354_, p_117355_, p_117356_, p_117357_, p_117358_);
            poseStack.popPose();
        }
    }
}
