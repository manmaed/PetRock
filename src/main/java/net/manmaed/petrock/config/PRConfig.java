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
    public static ForgeConfigSpec.IntValue STONEIUM_ORE_VAIN_SIZE;
    public static ForgeConfigSpec.IntValue STONEIUM_ORE_VAIN_AMOUNT;
    public static ForgeConfigSpec.IntValue DEEPSLATE_STONEIUM_ORE_VAIN_SIZE;
    public static ForgeConfigSpec.IntValue DEEPSLATE_STONEIUM_ORE_VAIN_AMOUNT;

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
       STONEIUM_ORE_VAIN_SIZE = COMMON_BUILDER.comment("Size of a Vain [DEFAULT: 10]")
                .defineInRange("stoneium_ore_vain_size", 10, 1, 50);
        STONEIUM_ORE_VAIN_AMOUNT = COMMON_BUILDER.comment("The Amount of Vains for a chunk [DEFAULT: 30]")
                .defineInRange("stoneium_ore_vain_amount", 30, 0, 100);
        DEEPSLATE_STONEIUM_ORE_VAIN_SIZE = COMMON_BUILDER.comment("Size of a Vain [DEFAULT: 10]")
                .defineInRange("deepslate_stoneium_ore_vain_size", 10, 1, 50);
        DEEPSLATE_STONEIUM_ORE_VAIN_AMOUNT = COMMON_BUILDER.comment("The Amount of Vains for a chunk [DEFAULT: 15]")
                .defineInRange("deepslate_stoneium_ore_vain_amount", 15, 0, 100);
    }
}
