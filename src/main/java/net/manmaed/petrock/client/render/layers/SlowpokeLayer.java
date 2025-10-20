package net.manmaed.petrock.client.render.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.manmaed.petrock.client.model.PRModels;
import net.manmaed.petrock.client.render.model.ModelSlowpokeHat;
import net.manmaed.petrock.hats.PRHats;
import net.manmaed.petrock.libs.RLHelper;
import net.minecraft.client.model.geom.EntityModelSet;
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
public class SlowpokeLayer extends RenderLayer {

    private static final ResourceLocation skin = RLHelper.location("textures/entity/event/slowpoke.png");
    private final ModelSlowpokeHat hat;

    public SlowpokeLayer(RenderLayerParent layerParent, EntityModelSet p_174494_) {
        super(layerParent);
        this.hat = new ModelSlowpokeHat(p_174494_.bakeLayer(PRModels.SLOWPOKE));

    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, Entity entity, float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {
        if(PRHats.slowpoke) {
            poseStack.pushPose();
            VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(skin));
            if (PRHats.birthday) {
                poseStack.translate(0F, -0.751F, 0.075F);
            } else {
                poseStack.translate(0F, -0.5626F, 0.075F);
            }
            hat.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);
            poseStack.popPose();
        }
    }
}
