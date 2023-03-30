package net.manmaed.petrock.client.render.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.client.model.PRModels;
import net.manmaed.petrock.client.render.model.ModelEggHat;
import net.manmaed.petrock.client.render.model.ModelPetRock;
import net.manmaed.petrock.entitys.EntityPetRock;
import net.manmaed.petrock.hats.PRHats;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class EggLayer<T extends EntityPetRock, M extends ModelPetRock<T>> extends RenderLayer<T, M> {

    private static final ResourceLocation skin = new ResourceLocation(PetRock.MOD_ID, "textures/entity/event/egg.png");
    private final ModelEggHat<T> hat;
    public EggLayer(RenderLayerParent layerParent, EntityModelSet modelSet) {
        super(layerParent);
        this.hat = new ModelEggHat<>(modelSet.bakeLayer(PRModels.EASTER_EGG));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, EntityPetRock entityPetRock, float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {
        if (PRHats.easter) {
            poseStack.pushPose();
            if (PRHats.slowpoke) {
                poseStack.scale(0.5f, 0.5f, 0.5f);
                poseStack.translate(0.0F, -1.375F, 0.085F);
            } else {
                poseStack.scale(0.5f, 0.5f, 0.5f);
                poseStack.translate(0.0F, 0.375F, -0.06F);
            }
            VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(skin));
            hat.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            poseStack.popPose();
        }
    }
}
