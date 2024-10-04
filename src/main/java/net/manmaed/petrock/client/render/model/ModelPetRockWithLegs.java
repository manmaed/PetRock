package net.manmaed.petrock.client.render.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.manmaed.petrock.entity.EntityPetRockWithLegs;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

/**
 * Created by manmaed on 14/06/2022.
 */
public class ModelPetRockWithLegs extends EntityModel<EntityPetRockWithLegs> {
    private final ModelPart petrock;
    private final ModelPart legs;
    private final ModelPart arms;
    public EntityPetRockWithLegs entityPetRockWithLegs;

    public ModelPetRockWithLegs(ModelPart root) {
        this.petrock = root.getChild("petrock");
        this.legs = root.getChild("legs");
        this.arms = root.getChild("arms");

        /*this.arm2 = root.getChild("arm2");
        this.arm1 = root.getChild("arm1");*/
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        //Base Petrock
        PartDefinition petrockcube = partdefinition.addOrReplaceChild("petrock", CubeListBuilder.create().texOffs(0, 0).addBox(-4.6F, -13.0F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        //New Parts:
        PartDefinition legs = partdefinition.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(-1.0F, 23.0F, -1.0F));
        PartDefinition arms = partdefinition.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(-1.0F, 23.0F, -1.0F));

        PartDefinition leg1 = legs.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(27, 12).addBox(-1.5F, 0.0F, -0.75F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(26, 12).addBox(-1.5F, 3.0F, -1.75F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.75F));

        PartDefinition leg2 = legs.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(26, 12).addBox(-1.5F, 3.0F, -1.75F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(27, 12).addBox(-1.5F, 0.0F, -0.75F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -3.0F, 0.75F));


        PartDefinition arm1 = arms.addOrReplaceChild("arm1", CubeListBuilder.create().texOffs(1, 22).addBox(-5.7F, -1.5F, -2.85F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 21).addBox(-5.7F, -1.5F, -1.85F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -5.5F, -1.75F));

        PartDefinition arm2 = arms.addOrReplaceChild("arm2", CubeListBuilder.create().texOffs(1, 22).addBox(3.6F, -1.5F, -2.85F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 21).addBox(4.6F, -1.5F, -2.25F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -5.5F, -1.75F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }
    @Override
    public void setupAnim(EntityPetRockWithLegs entity,  float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        //left
        this.arms.getChild("arm1").xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / 1.0F;
        this.legs.getChild("leg1").xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount / 1.0F;

        //right
        this.arms.getChild("arm2").xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F / 1.0F;
        this.legs.getChild("leg2").xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / 1.0F;
        entityPetRockWithLegs = entity;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int ihavenocluetrynegone) {
        poseStack.pushPose();
        petrock.render(poseStack, buffer, packedLight, packedOverlay);
        arms.render(poseStack, buffer, packedLight, packedOverlay);
        if (!entityPetRockWithLegs.isInSittingPose()) {
            legs.render(poseStack, buffer, packedLight, packedOverlay);
        }
        poseStack.popPose();
    }
}