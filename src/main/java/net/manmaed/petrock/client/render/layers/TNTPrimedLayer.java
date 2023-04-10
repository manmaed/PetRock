package net.manmaed.petrock.client.render.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.client.model.PRModels;
import net.manmaed.petrock.client.render.model.ModelTNTPrimed;
import net.manmaed.petrock.hats.Trolling;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class TNTPrimedLayer extends RenderLayer {

    private static final ResourceLocation full = new ResourceLocation(PetRock.MOD_ID, "textures/entity/event/tnt_full.png");


    private final ModelTNTPrimed tntPrimed;

    public TNTPrimedLayer(RenderLayerParent layerParent, EntityModelSet modelSet) {
        super(layerParent);
        this.tntPrimed = new ModelTNTPrimed(modelSet.bakeLayer(PRModels.TNT_PRIMED));
    }

    @Override

    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, Entity entity, float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {
        if (Trolling.flashingmode) {
            poseStack.pushPose();
            poseStack.scale(1.05F, 1.05F, 1.05F);
            poseStack.translate(0F, -0.05F, 0F);
            VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityCutout(full));
            tntPrimed.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            poseStack.popPose();
        }
    }
}
