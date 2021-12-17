package net.manmaed.petrock.client.render.layers;

/**
 * Created by manmaed on 31/08/2019.
 */
public class HalloweenFeatureRenderer {} //TODO: Implement
/*public class HalloweenFeatureRenderer extends LayerRenderer<EntityPetRock, ModelPetRock<EntityPetRock>> {

    private final ModelCreeperHat hat = new ModelCreeperHat();
    private static final ResourceLocation skin = new ResourceLocation(Refs.id, "textures/entity/event/creeper.png");

    public HalloweenFeatureRenderer(IEntityRenderer entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, EntityPetRock entityPetRock, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (PRHats.halloween) {
            matrixStackIn.push();
            matrixStackIn.translate(0F, -0.5626F, 0F);
            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntitySolid(skin));
            hat.renderCreeper(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY);
            matrixStackIn.pop();
        }
    }
}*/
