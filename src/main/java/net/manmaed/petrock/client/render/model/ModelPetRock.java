package net.manmaed.petrock.client.render.model;

/**
 * Created by manmaed on 26/02/2017.
 */

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.manmaed.petrock.entity.EntityPetRock;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

/**
 * ModelPetRock - manmaed
 * Created using Tabula 7.0.0
 */

public class ModelPetRock extends EntityModel<EntityPetRock> {
    private final ModelPart petrock;

    public ModelPetRock(ModelPart root) {
        this.petrock = root.getChild("petrock");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition petrock = partdefinition.addOrReplaceChild("petrock", CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-4.5F, -9.0F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }
    @Override
    public void setupAnim(EntityPetRock entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }


    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int ihavenocluetrynegone) {
        petrock.render(poseStack, buffer, packedLight, packedOverlay);
    }
}