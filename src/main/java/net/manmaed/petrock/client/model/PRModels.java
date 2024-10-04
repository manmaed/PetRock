package net.manmaed.petrock.client.model;

import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.libs.RLHelper;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

/**
 * Created by manmaed on 17/12/2021.
 */
public class PRModels {

    public static final ModelLayerLocation PETROCK = makeModelLayerLocation("petrock");
    public static final ModelLayerLocation PETROCKWITHLEGS = makeModelLayerLocation("petrockwithlegs");

    //Layers
    public static final ModelLayerLocation CAKE = makeModelLayerLocation("cake");
    public static final ModelLayerLocation CREEPER = makeModelLayerLocation("creeper");
    public static final ModelLayerLocation SANTA = makeModelLayerLocation("santa");
    public static final ModelLayerLocation SLOWPOKE = makeModelLayerLocation("slowpoke");
    public static final ModelLayerLocation CAGE = makeModelLayerLocation("cage");
    public static final ModelLayerLocation SIGN = makeModelLayerLocation("sign");

    public static final ModelLayerLocation EASTER_EGG = makeModelLayerLocation("egg");
    public static final ModelLayerLocation HOOD = makeModelLayerLocation("hood");
    public static final ModelLayerLocation TNT_SIDE = makeModelLayerLocation("tnt_side");
    public static final ModelLayerLocation TNT_TOP = makeModelLayerLocation("tnt_top");
    public static final ModelLayerLocation TNT_BOTTOM = makeModelLayerLocation("tnt_botom");
    public static final ModelLayerLocation TNT_PRIMED = makeModelLayerLocation("tnt_primed");
    /*public static final ModelLayerLocation PETROCK = new ModelLayerLocation(new ResourceLocation(PetRock.MOD_ID, "petrock"), "petrock");*/



    public static ModelLayerLocation makeModelLayerLocation(String name) {
        return new ModelLayerLocation(RLHelper.location(name), name);
    }

}
