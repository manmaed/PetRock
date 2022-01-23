package net.manmaed.petrock.client.render.layers;


import com.mojang.blaze3d.vertex.PoseStack;
import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.client.render.model.ModelChristmasHat;
import net.manmaed.petrock.client.render.model.ModelChristmasHatBB;
import net.manmaed.petrock.client.render.model.ModelPetRock;
import net.manmaed.petrock.entitys.EntityPetRock;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

/**
 * Created by manmaed on 31/08/2019.
 */
//TODO: implement this class via RenderLayer
public class ChristmasFeatureRenderer { }
/*public class ChristmasFeatureRenderer extends RenderLayer<EntityPetRock, ModelPetRock<EntityPetRock>> {



    private final ModelChristmasHat hat = new ModelChristmasHatBB<EntityPetRock>;
    private static final ResourceLocation skin = new ResourceLocation(PetRock.MOD_ID, "textures/entity/event/xmas.png");

    public ChristmasFeatureRenderer(RenderLayerParent<EntityPetRock, ModelPetRock<EntityPetRock>> p_117346_) {
        super(p_117346_);
    }

    @Override
    public void render(PoseStack p_117349_, MultiBufferSource p_117350_, int p_117351_, EntityPetRock p_117352_, float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {

    }
}*/ //TODO: Implement
/*public class ChristmasFeatureRenderer extends LayerRenderer<EntityPetRock, ModelPetRock<EntityPetRock>> {

    private final ModelChristmasHat hat = new ModelChristmasHat();
    private static final ResourceLocation skin = new ResourceLocation(Refs.id, "textures/entity/event/xmas.png");

    public ChristmasFeatureRenderer(IEntityRenderer entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, EntityPetRock entityPetRock, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (PRHats.christmas) {
            matrixStackIn.push();
            if (PRHats.slowpoke) {
                Float size = 1.5F;
                matrixStackIn.translate(0F, -2.195F, 0.05F);
                matrixStackIn.scale(size, size, size);
            } else {
                matrixStackIn.translate(0F, -0.5626F, 0F);
            }
            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntitySolid(skin));
            hat.renderSanta(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY);
            matrixStackIn.pop();
        }
    }
}*/
