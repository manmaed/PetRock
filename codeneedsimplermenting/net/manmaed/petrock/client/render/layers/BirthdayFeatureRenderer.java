package net.manmaed.petrock.client.render.layers;

/**
 * Created by manmaed on 30/08/2019.
 */
public class BirthdayFeatureRenderer {} //TODO: Implement Birthday Feature
/*public class BirthdayFeatureRenderer extends LayerRenderer<EntityPetRock, ModelPetRock<EntityPetRock>> {

    private final ModelCakeHat hat = new ModelCakeHat();
    private static final ResourceLocation skin = new ResourceLocation(Refs.id, "textures/entity/event/cake.png");

    public BirthdayFeatureRenderer(IEntityRenderer entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, EntityPetRock entityPetRock, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (PRHats.birthday) {
            matrixStackIn.push();
            matrixStackIn.translate(0F, -0.5626F, 0F);
            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntitySolid(skin));
            hat.renderCake(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY);
            matrixStackIn.pop();
        }
    }
}*/
