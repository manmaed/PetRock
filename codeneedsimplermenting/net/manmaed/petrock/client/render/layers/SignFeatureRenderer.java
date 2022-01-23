package net.manmaed.petrock.client.render.layers;


/**
 * Created by manmaed on 30/08/2019.
 */
public class SignFeatureRenderer {} //TODO: Implement
/*public class SignFeatureRenderer extends LayerRenderer<EntityPetRock, ModelPetRock<EntityPetRock>> {

    private final ModelSign hat = new ModelSign();
    private static final ResourceLocation skin = new ResourceLocation(Refs.id, "textures/entity/event/sign.png");

    public SignFeatureRenderer(IEntityRenderer entityRendererIn) {
        super(entityRendererIn);
    }


    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, EntityPetRock entityPetRock, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (PRHats.loneztar) {
            Float size = 0.17F;
            matrixStackIn.push();

            //-Left+Right // -Up+Down // -Forward+Back
            matrixStackIn.translate(-0.3F, 0.78F, -0.5F);
            matrixStackIn.scale(size, size, size);
            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntitySolid(skin));
            hat.renderSign(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY);
            matrixStackIn.pop();
        }
    }
}*/
