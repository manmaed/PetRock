package net.manmaed.petrock.client.render.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.client.model.PRModels;
import net.manmaed.petrock.client.render.model.ModelSlowpokeHat;
import net.manmaed.petrock.entity.EntityPetRockWithLegs;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

/**
 * Created by manmaed on 24/01/2022.
 */
public class MiniSlowpokeLayer<T extends EntityPetRockWithLegs, M extends EntityModel<T>> extends RenderLayer<T, M> {

    private static final ResourceLocation skin = new ResourceLocation(PetRock.MOD_ID, "textures/entity/event/slowpoke.png");
    private final ModelSlowpokeHat hat;

    public MiniSlowpokeLayer(RenderLayerParent layerParent, EntityModelSet entityModelSet) {
        super(layerParent);
        this.hat = new ModelSlowpokeHat(entityModelSet.bakeLayer(PRModels.SLOWPOKE));

    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, EntityPetRockWithLegs entityPetRock, float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {
        poseStack.pushPose();
        poseStack.scale(0.35F, 0.35F, 0.35F);
        poseStack.translate(0F, 0.462F, 0F);
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(skin));
        hat.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        poseStack.popPose();
    }
}
