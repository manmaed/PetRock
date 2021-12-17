package net.manmaed.petrock.client.render.layers;


/**
 * Created by manmaed on 31/08/2019.
 */
public class ChristmasFeatureRenderer {} //TODO: Implement
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
