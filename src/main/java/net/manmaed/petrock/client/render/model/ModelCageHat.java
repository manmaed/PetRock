package net.manmaed.petrock.client.render.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.manmaed.petrock.entitys.EntityPetRock;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;

public class ModelCageHat<T extends EntityPetRock> extends Model {
	private final ModelPart RB1;
	private final ModelPart RB3;
	private final ModelPart TB1;
	private final ModelPart RB2;
	private final ModelPart RB4;
	private final ModelPart TB2;
	private final ModelPart snib4;
	private final ModelPart snib5;
	private final ModelPart snib6;
	private final ModelPart nib12;
	private final ModelPart nib11;
	private final ModelPart nib10;
	private final ModelPart RiB2;
	private final ModelPart nib9;
	private final ModelPart nib8;
	private final ModelPart nib7;
	private final ModelPart LeB2;
	private final ModelPart RiB3;
	private final ModelPart LeB3;
	private final ModelPart FB1;
	private final ModelPart snib1;
	private final ModelPart FB3;
	private final ModelPart snib2;
	private final ModelPart FB2;
	private final ModelPart snib3;
	private final ModelPart nib2;
	private final ModelPart FB4;
	private final ModelPart nib1;
	private final ModelPart nib6;
	private final ModelPart nib5;
	private final ModelPart nib4;
	private final ModelPart nib3;

	public ModelCageHat(ModelPart root) {
		super(RenderType::entitySolid);
		this.RB1 = root.getChild("RB1");
		this.RB3 = root.getChild("RB3");
		this.TB1 = root.getChild("TB1");
		this.RB2 = root.getChild("RB2");
		this.RB4 = root.getChild("RB4");
		this.TB2 = root.getChild("TB2");
		this.snib4 = root.getChild("snib4");
		this.snib5 = root.getChild("snib5");
		this.snib6 = root.getChild("snib6");
		this.nib12 = root.getChild("nib12");
		this.nib11 = root.getChild("nib11");
		this.nib10 = root.getChild("nib10");
		this.RiB2 = root.getChild("RiB2");
		this.nib9 = root.getChild("nib9");
		this.nib8 = root.getChild("nib8");
		this.nib7 = root.getChild("nib7");
		this.LeB2 = root.getChild("LeB2");
		this.RiB3 = root.getChild("RiB3");
		this.LeB3 = root.getChild("LeB3");
		this.FB1 = root.getChild("FB1");
		this.snib1 = root.getChild("snib1");
		this.FB3 = root.getChild("FB3");
		this.snib2 = root.getChild("snib2");
		this.FB2 = root.getChild("FB2");
		this.snib3 = root.getChild("snib3");
		this.nib2 = root.getChild("nib2");
		this.FB4 = root.getChild("FB4");
		this.nib1 = root.getChild("nib1");
		this.nib6 = root.getChild("nib6");
		this.nib5 = root.getChild("nib5");
		this.nib4 = root.getChild("nib4");
		this.nib3 = root.getChild("nib3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition RB1 = partdefinition.addOrReplaceChild("RB1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 33.0F, 6.0F));

		PartDefinition RB3 = partdefinition.addOrReplaceChild("RB3", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 33.0F, 6.0F));

		PartDefinition TB1 = partdefinition.addOrReplaceChild("TB1", CubeListBuilder.create().texOffs(0, 4).addBox(-1.0F, -10.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 23.0F, 0.0F));

		PartDefinition RB2 = partdefinition.addOrReplaceChild("RB2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 33.0F, 6.0F));

		PartDefinition RB4 = partdefinition.addOrReplaceChild("RB4", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 33.0F, 6.0F));

		PartDefinition TB2 = partdefinition.addOrReplaceChild("TB2", CubeListBuilder.create().texOffs(0, 4).addBox(-1.0F, -10.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 23.0F, 0.0F));

		PartDefinition snib4 = partdefinition.addOrReplaceChild("snib4", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -10.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 23.0F, -5.0F));

		PartDefinition snib5 = partdefinition.addOrReplaceChild("snib5", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -10.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 23.0F, -1.0F));

		PartDefinition snib6 = partdefinition.addOrReplaceChild("snib6", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -10.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 23.0F, 3.0F));

		PartDefinition nib12 = partdefinition.addOrReplaceChild("nib12", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -10.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 23.0F, 5.0F));

		PartDefinition nib11 = partdefinition.addOrReplaceChild("nib11", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -10.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 23.0F, 1.0F));

		PartDefinition nib10 = partdefinition.addOrReplaceChild("nib10", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -10.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 23.0F, -3.0F));

		PartDefinition RiB2 = partdefinition.addOrReplaceChild("RiB2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 33.0F, -2.0F));

		PartDefinition nib9 = partdefinition.addOrReplaceChild("nib9", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -10.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 23.0F, -7.0F));

		PartDefinition nib8 = partdefinition.addOrReplaceChild("nib8", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -10.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 5.0F));

		PartDefinition nib7 = partdefinition.addOrReplaceChild("nib7", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -10.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 1.0F));

		PartDefinition LeB2 = partdefinition.addOrReplaceChild("LeB2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -20.1F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 33.1F, -2.0F));

		PartDefinition RiB3 = partdefinition.addOrReplaceChild("RiB3", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 33.0F, 2.0F));

		PartDefinition LeB3 = partdefinition.addOrReplaceChild("LeB3", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -20.1F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 33.1F, 2.0F));

		PartDefinition FB1 = partdefinition.addOrReplaceChild("FB1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 33.0F, -6.0F));

		PartDefinition snib1 = partdefinition.addOrReplaceChild("snib1", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -10.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 23.0F, -5.0F));

		PartDefinition FB3 = partdefinition.addOrReplaceChild("FB3", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 33.0F, -6.0F));

		PartDefinition snib2 = partdefinition.addOrReplaceChild("snib2", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -10.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 23.0F, -1.0F));

		PartDefinition FB2 = partdefinition.addOrReplaceChild("FB2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 33.0F, -6.0F));

		PartDefinition snib3 = partdefinition.addOrReplaceChild("snib3", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -10.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 23.0F, 3.0F));

		PartDefinition nib2 = partdefinition.addOrReplaceChild("nib2", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -10.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 23.0F, -3.0F));

		PartDefinition FB4 = partdefinition.addOrReplaceChild("FB4", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 33.0F, -6.0F));

		PartDefinition nib1 = partdefinition.addOrReplaceChild("nib1", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -10.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 23.0F, -7.0F));

		PartDefinition nib6 = partdefinition.addOrReplaceChild("nib6", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -10.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, -3.0F));

		PartDefinition nib5 = partdefinition.addOrReplaceChild("nib5", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -10.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, -7.0F));

		PartDefinition nib4 = partdefinition.addOrReplaceChild("nib4", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -10.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 23.0F, 5.0F));

		PartDefinition nib3 = partdefinition.addOrReplaceChild("nib3", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -10.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 23.0F, 1.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		RB1.render(poseStack, buffer, packedLight, packedOverlay);
		RB3.render(poseStack, buffer, packedLight, packedOverlay);
		TB1.render(poseStack, buffer, packedLight, packedOverlay);
		RB2.render(poseStack, buffer, packedLight, packedOverlay);
		RB4.render(poseStack, buffer, packedLight, packedOverlay);
		TB2.render(poseStack, buffer, packedLight, packedOverlay);
		snib4.render(poseStack, buffer, packedLight, packedOverlay);
		snib5.render(poseStack, buffer, packedLight, packedOverlay);
		snib6.render(poseStack, buffer, packedLight, packedOverlay);
		nib12.render(poseStack, buffer, packedLight, packedOverlay);
		nib11.render(poseStack, buffer, packedLight, packedOverlay);
		nib10.render(poseStack, buffer, packedLight, packedOverlay);
		RiB2.render(poseStack, buffer, packedLight, packedOverlay);
		nib9.render(poseStack, buffer, packedLight, packedOverlay);
		nib8.render(poseStack, buffer, packedLight, packedOverlay);
		nib7.render(poseStack, buffer, packedLight, packedOverlay);
		LeB2.render(poseStack, buffer, packedLight, packedOverlay);
		RiB3.render(poseStack, buffer, packedLight, packedOverlay);
		LeB3.render(poseStack, buffer, packedLight, packedOverlay);
		FB1.render(poseStack, buffer, packedLight, packedOverlay);
		snib1.render(poseStack, buffer, packedLight, packedOverlay);
		FB3.render(poseStack, buffer, packedLight, packedOverlay);
		snib2.render(poseStack, buffer, packedLight, packedOverlay);
		FB2.render(poseStack, buffer, packedLight, packedOverlay);
		snib3.render(poseStack, buffer, packedLight, packedOverlay);
		nib2.render(poseStack, buffer, packedLight, packedOverlay);
		FB4.render(poseStack, buffer, packedLight, packedOverlay);
		nib1.render(poseStack, buffer, packedLight, packedOverlay);
		nib6.render(poseStack, buffer, packedLight, packedOverlay);
		nib5.render(poseStack, buffer, packedLight, packedOverlay);
		nib4.render(poseStack, buffer, packedLight, packedOverlay);
		nib3.render(poseStack, buffer, packedLight, packedOverlay);
	}
}