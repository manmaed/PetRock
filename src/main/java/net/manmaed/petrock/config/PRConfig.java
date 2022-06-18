package net.manmaed.petrock.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PRConfig {
    private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
    private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;

    public static final String CATEGORY_WORLDGEN = "worldgen";

    public static ForgeConfigSpec.BooleanValue ENABLE_WORLD_GEN;

    static {
        COMMON_BUILDER.comment("WorldGen Settings").push(CATEGORY_WORLDGEN);
        setupWorldGenConfig();
        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();
/*        CLIENT_CONFIG = CLIENT_BUILDER.build();*/
    }

    private static void setupWorldGenConfig(){
        ENABLE_WORLD_GEN = COMMON_BUILDER.comment("World Gen? [DEFAULT: true]")
                .define("worldgen_enabled", true);
    }
}
