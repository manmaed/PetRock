package net.manmaed.petrock.client.render.layers;


/**
 * Created by manmaed on 30/08/2019.
 */
public class CageFeatureRenderer {} //TODO: Implement
/*public class CageFeatureRenderer extends RenderLayer<EntityPetRock, ModelPetRock<EntityPetRock>> {

    private final ModelCageHat hat = new ModelCageHat();
    private static final ResourceLocation skin = new ResourceLocation(Refs.id, "textures/entity/event/cage.png");

    public CageFeatureRenderer(IEntityRenderer entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, EntityPetRock entityPetRock, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (PRHats.loneztar) {
            matrixStackIn.push();
            matrixStackIn.translate(0F, -0.5626F, 0F);
            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntitySolid(skin));
            hat.renderCage(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY);
            matrixStackIn.pop();
        }
    }

    @Override
    public void render(PoseStack p_117349_, MultiBufferSource p_117350_, int p_117351_, EntityPetRock p_117352_, float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {

    }
}*/
