package net.manmaed.petrock.client.render.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.manmaed.petrock.entitys.EntityPetRock;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;

public class ModelEggHat<T extends EntityPetRock> extends Model {
    private final ModelPart Egg;

    public ModelEggHat(ModelPart root) {
        super(RenderType::entitySolid);
        this.Egg = root.getChild("Egg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition Egg = partdefinition.addOrReplaceChild("Egg", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition layer1 = Egg.addOrReplaceChild("layer1", CubeListBuilder.create().texOffs(28, 22).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 20).addBox(-1.0F, -1.0F, 2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(50, 44).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition layer2 = Egg.addOrReplaceChild("layer2", CubeListBuilder.create().texOffs(48, 49).addBox(-3.0F, -1.0F, 3.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(48, 41).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 50).addBox(-4.0F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(42, 49).addBox(1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -1.0F, -1.0F));

        PartDefinition layer3 = Egg.addOrReplaceChild("layer3", CubeListBuilder.create().texOffs(54, 26).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(19, 54).addBox(-2.0F, -3.0F, 4.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 49).addBox(-4.0F, -3.0F, -1.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(36, 48).addBox(3.0F, -3.0F, -1.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(8, 35).addBox(2.0F, -3.0F, -2.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 34).addBox(-3.0F, -3.0F, -2.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition layer4 = Egg.addOrReplaceChild("layer4", CubeListBuilder.create().texOffs(48, 27).addBox(4.0F, -4.0F, -1.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(48, 11).addBox(-5.0F, -4.0F, -1.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(54, 13).addBox(-2.0F, -4.0F, 5.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(54, 11).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 55).addBox(2.0F, -4.0F, -3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(53, 54).addBox(2.0F, -4.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(37, 54).addBox(-4.0F, -4.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(45, 54).addBox(-4.0F, -4.0F, -3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition layer5 = Egg.addOrReplaceChild("layer5", CubeListBuilder.create().texOffs(16, 33).addBox(4.0F, -5.0F, -2.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(30, 32).addBox(-5.0F, -5.0F, -2.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(38, 34).addBox(-3.0F, -5.0F, -4.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 32).addBox(-3.0F, -5.0F, 5.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 45).addBox(2.0F, -5.0F, -3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(15, 50).addBox(2.0F, -5.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(54, 4).addBox(-4.0F, -5.0F, -3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(54, 28).addBox(-4.0F, -5.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition layer6 = Egg.addOrReplaceChild("layer6", CubeListBuilder.create().texOffs(30, 25).addBox(4.0F, -6.0F, -2.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(30, 9).addBox(-5.0F, -6.0F, -2.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(38, 29).addBox(-3.0F, -6.0F, 5.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 27).addBox(-3.0F, -6.0F, -4.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 18).addBox(-1.0F, -6.0F, -5.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 24).addBox(-1.0F, -6.0F, 6.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 28).addBox(-6.0F, -6.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 27).addBox(5.0F, -6.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(20, 10).addBox(2.0F, -6.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(20, 13).addBox(-4.0F, -6.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 21).addBox(-4.0F, -6.0F, -3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(10, 22).addBox(2.0F, -6.0F, -3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition layer7 = Egg.addOrReplaceChild("layer7", CubeListBuilder.create().texOffs(9, 54).addBox(-2.0F, -7.0F, 6.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(29, 53).addBox(-2.0F, -7.0F, -5.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(30, 47).addBox(-6.0F, -7.0F, -1.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(6, 47).addBox(5.0F, -7.0F, -1.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(20, 9).addBox(4.0F, -7.0F, -3.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(20, 0).addBox(-5.0F, -7.0F, -3.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(38, 9).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 7).addBox(-4.0F, -7.0F, 5.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition layer8 = Egg.addOrReplaceChild("layer8", CubeListBuilder.create().texOffs(53, 21).addBox(-2.0F, -7.0F, 6.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(53, 19).addBox(-2.0F, -7.0F, -5.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 36).addBox(-6.0F, -7.0F, -1.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(14, 45).addBox(5.0F, -7.0F, -1.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(10, 19).addBox(4.0F, -7.0F, -3.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(-5.0F, -7.0F, -3.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(38, 4).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 2).addBox(-4.0F, -7.0F, 5.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition layer9 = Egg.addOrReplaceChild("layer9", CubeListBuilder.create().texOffs(52, 52).addBox(-2.0F, -7.0F, 6.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(52, 37).addBox(-2.0F, -7.0F, -5.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 45).addBox(-6.0F, -7.0F, -1.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(44, 44).addBox(5.0F, -7.0F, -1.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(10, 10).addBox(4.0F, -7.0F, -3.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(10, 1).addBox(-5.0F, -7.0F, -3.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(38, 0).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 22).addBox(-4.0F, -7.0F, 5.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

        PartDefinition layer10 = Egg.addOrReplaceChild("layer10", CubeListBuilder.create().texOffs(52, 35).addBox(-2.0F, -7.0F, 6.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(52, 16).addBox(-2.0F, -7.0F, -5.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 44).addBox(-6.0F, -7.0F, -1.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(38, 43).addBox(5.0F, -7.0F, -1.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 9).addBox(4.0F, -7.0F, -3.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.0F, -7.0F, -3.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(36, 20).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 18).addBox(-4.0F, -7.0F, 5.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

        PartDefinition layer11 = Egg.addOrReplaceChild("layer11", CubeListBuilder.create().texOffs(30, 0).addBox(4.0F, -6.0F, -2.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(28, 18).addBox(-5.0F, -6.0F, -2.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(38, 25).addBox(-3.0F, -6.0F, 5.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 16).addBox(-3.0F, -6.0F, -4.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 6).addBox(-1.0F, -6.0F, -5.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 15).addBox(-1.0F, -6.0F, 6.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 22).addBox(-6.0F, -6.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(20, 19).addBox(5.0F, -6.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(20, 3).addBox(2.0F, -6.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(20, 0).addBox(-4.0F, -6.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(10, 19).addBox(-4.0F, -6.0F, -3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(2.0F, -6.0F, -3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition layer12 = Egg.addOrReplaceChild("layer12", CubeListBuilder.create().texOffs(8, 28).addBox(4.0F, -5.0F, -2.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 27).addBox(-5.0F, -5.0F, -2.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(38, 13).addBox(-3.0F, -5.0F, -4.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 11).addBox(-3.0F, -5.0F, 5.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 13).addBox(2.0F, -5.0F, -3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 12).addBox(2.0F, -5.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(10, 10).addBox(-4.0F, -5.0F, -3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(10, 3).addBox(-4.0F, -5.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

        PartDefinition layer13 = Egg.addOrReplaceChild("layer13", CubeListBuilder.create().texOffs(32, 42).addBox(4.0F, -4.0F, -1.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(8, 42).addBox(-5.0F, -4.0F, -1.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(6, 52).addBox(-2.0F, -4.0F, 5.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(51, 33).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 0).addBox(2.0F, -4.0F, -3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 9).addBox(2.0F, -4.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 3).addBox(-4.0F, -4.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.0F, -4.0F, -3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, 0.0F));

        PartDefinition layer14 = Egg.addOrReplaceChild("layer14", CubeListBuilder.create().texOffs(51, 24).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 36).addBox(-2.0F, -3.0F, 4.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 38).addBox(-4.0F, -3.0F, -1.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(18, 40).addBox(3.0F, -3.0F, -1.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(22, 26).addBox(2.0F, -3.0F, -2.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(20, 19).addBox(-3.0F, -3.0F, -2.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, 0.0F));

        PartDefinition layer15 = Egg.addOrReplaceChild("layer15", CubeListBuilder.create().texOffs(0, 42).addBox(-3.0F, -1.0F, 3.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(32, 39).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(26, 39).addBox(-4.0F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(24, 33).addBox(1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -14.0F, -1.0F));

        PartDefinition layer16 = Egg.addOrReplaceChild("layer16", CubeListBuilder.create().texOffs(10, 6).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).addBox(-1.0F, -1.0F, 2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 28).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -15.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        Egg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
