package net.manmaed.petrock.client.render.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.client.render.model.ModelCakeHat;
import net.manmaed.petrock.client.render.model.ModelPetRock;
import net.manmaed.petrock.entitys.EntityPetRock;
import net.minecraft.client.gui.screens.Overlay;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.ShulkerRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.pipeline.IVertexConsumer;

/**
 * Created by manmaed on 24/01/2022.
 */
public class BirthdayFeatureRenderer<T extends EntityPetRock, M extends ModelCakeHat<T>> extends RenderLayer<T, M> {

    //private ModelCakeHat hat = new ModelCakeHat;
    private final M hat;
    private static final ResourceLocation skin = new ResourceLocation(PetRock.MOD_ID, "textures/entity/event/cake.png");

    public BirthdayFeatureRenderer(RenderLayerParent<T, M> layerParent) {
        super(layerParent, new ModelCakeHat<EntityPetRock>());
        this.hat = new ModelCakeHat<T>(layerParent.getModel().);

    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, T entityPetRock, float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {
        //TODO: Add birthday feature form Hat class
        if(true) {

            poseStack.pushPose();
            VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(skin));
            //TODO Fix Rendering
            hat.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            poseStack.popPose();
        }
    }
}
