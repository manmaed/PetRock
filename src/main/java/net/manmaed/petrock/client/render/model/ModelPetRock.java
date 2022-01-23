package net.manmaed.petrock.client.render.model;

/**
 * Created by manmaed on 26/02/2017.
 */

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.manmaed.petrock.PetRock;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

/**
 * ModelPetRock - manmaed
 * Created using Tabula 7.0.0
 */

public class ModelPetRock<T extends Entity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(PetRock.MOD_ID, "petrock"), "petrock");
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
    public void setupAnim(T p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        petrock.render(poseStack, buffer, packedLight, packedOverlay);
    }
}