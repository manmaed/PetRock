package net.manmaed.petrock.client.render.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.client.model.PRModels;
import net.manmaed.petrock.client.render.model.ModelPetRock;
import net.manmaed.petrock.client.render.model.ModelSantaHat;
import net.manmaed.petrock.entity.EntityPetRock;
import net.manmaed.petrock.hats.PRHats;
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
public class ChristmasLayer<T extends EntityPetRock, M extends ModelPetRock<T>> extends RenderLayer<T, M> {

    private static final ResourceLocation skin = new ResourceLocation(PetRock.MOD_ID, "textures/entity/event/xmas.png");
    private final ModelSantaHat<T> hat;

    public ChristmasLayer(RenderLayerParent layerParent, EntityModelSet p_174494_) {
        super(layerParent);
        this.hat = new ModelSantaHat<>(p_174494_.bakeLayer(PRModels.SANTA));

    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, EntityPetRock entityPetRock, float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {
        if(PRHats.christmas) {
            poseStack.pushPose();
            if(PRHats.slowpoke){
                Float size = 1.5F;
                poseStack.translate(0F, -2.188F, 0.075F);
                poseStack.scale(size, size, size);
            } else {
                poseStack.translate(0F, -0.5626F, 0F);
            }
            VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(skin));
            hat.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            poseStack.popPose();
        }
    }
}
