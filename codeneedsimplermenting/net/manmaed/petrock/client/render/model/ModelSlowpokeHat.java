package net.manmaed.petrock.client.render.model;

import net.manmaed.petrock.PetRock;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.Entity;

/**
 * ModelSlowpokeHat - manmaed
 * Created using Tabula 7.0.0
 */
public class ModelSlowpokeHat<T extends Entity> extends HierarchicalModel<T> {

    public ModelPart root;
    public ModelPart Shape1;
    public ModelPart Shape1_1;
    public ModelPart Shape1_2;
    public ModelPart head_hat;
    public ModelPart Shape1_3;
    public ModelPart Shape1_4;
    public ModelPart Shape1_5;

    public ModelSlowpokeHat(ModelPart part) {
        this.root = part;
        this.Shape1 = part.getChild("shape1"); //TODO RENAME
        this.Shape1_1 = part.getChild("shape1_1"); //TODO RENAME
        this.Shape1_2 = part.getChild("shape1_2"); //TODO RENAME
        this.head_hat = part.getChild("head_hat");
        this.Shape1_3 = part.getChild("shape1_3"); //TODO RENAME
        this.Shape1_4 = part.getChild("shape1_4"); //TODO RENAME
        this.Shape1_5 = part.getChild("shape1_5"); //TODO RENAME
    }

    public static LayerDefinition createBodyLayer(){
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdef = meshdefinition.getRoot();
        partdef.addOrReplaceChild("shape1",
                CubeListBuilder.create()
                        .texOffs(32 ,1)
                        .addBox(-1.5F, 10.0F, -1.5F, 2, 4, 3),
                PartPose.offset(0.0F, -1.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
    public void setupAnim(T p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

    }
}

//TODO: Implement
/*public class ModelSlowpokeHat<T extends Entity> extends SegmentedModel<T> {
    public ModelRenderer Shape1;
    public ModelRenderer Shape1_1;
    public ModelRenderer Shape1_2;
    public ModelRenderer head2;
    public ModelRenderer Shape1_3;
    public ModelRenderer Shape1_4;
    public ModelRenderer Shape1_5;

    public ModelSlowpokeHat() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Shape1_1 = new ModelRenderer(this, 32, 1);
        this.Shape1_1.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.Shape1_1.addBox(-1.5F, 10.0F, -1.5F, 2, 4, 3, 0.0F);
        this.setRotateAngle(Shape1_1, 3.141592653589793F, 1.5707963267948966F, 3.141592653589793F);
        this.Shape1_5 = new ModelRenderer(this, 0, 0);
        this.Shape1_5.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.Shape1_5.addBox(-4.0F, 2.0F, -3.5F, 8, 8, 8, 0.0F);
        this.Shape1_2 = new ModelRenderer(this, 32, 8);
        this.Shape1_2.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.Shape1_2.addBox(-1.0F, 10.0F, 0.0F, 4, 2, 2, 0.0F);
        this.setRotateAngle(Shape1_2, -0.017453292519943295F, 1.3962634015954636F, 0.0F);
        this.Shape1_4 = new ModelRenderer(this, 32, 8);
        this.Shape1_4.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.Shape1_4.addBox(-1.0F, 10.0F, -2.0F, 4, 2, 2, 0.0F);
        this.setRotateAngle(Shape1_4, 3.141592653589793F, 1.3962634015954636F, 3.141592653589793F);
        this.Shape1 = new ModelRenderer(this, 0, 16);
        this.Shape1.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.Shape1.addBox(-1.5F, 10.0F, 1.5F, 2, 4, 2, 0.0F);
        this.setRotateAngle(Shape1, 3.141592653589793F, 1.5707963267948966F, 3.141592653589793F);
        this.head2 = new ModelRenderer(this, 0, 16);
        this.head2.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.head2.addBox(-4.0F, 2.0F, -3.5F, 8, 8, 8, 0.1F);
        this.Shape1_3 = new ModelRenderer(this, 0, 16);
        this.Shape1_3.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.Shape1_3.addBox(-1.5F, 10.0F, -3.5F, 2, 4, 2, 0.0F);
        this.setRotateAngle(Shape1_3, 3.141592653589793F, 1.5707963267948966F, 3.141592653589793F);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(
                this.Shape1_1,
                this.Shape1_5,
                this.Shape1_2,
                this.Shape1_4,
                this.Shape1,
                this.head2,
                this.Shape1_3
        );
    }

    public void renderSlowpoke(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn) {
        this.Shape1_1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Shape1_5.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Shape1_2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Shape1_4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Shape1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.head2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Shape1_3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    *//**
     * This is a helper function from Tabula to set the rotation of model parts
     *//*
    public void setRotateAngle(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX  = x;
        model.rotateAngleY  = y;
        model.rotateAngleZ  = z;
    }
}*/
