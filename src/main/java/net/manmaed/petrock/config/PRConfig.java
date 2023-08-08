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
    public static final String CATEGORY_FUN = "fun";

    public static ForgeConfigSpec.BooleanValue ENABLE_WORLD_GEN;
    public static ForgeConfigSpec.BooleanValue DISABLE_TROLL;
    public static ForgeConfigSpec.BooleanValue IS_APRIL_FOOLS_EVERYDAY;

    static {
        COMMON_BUILDER.comment("WorldGen Settings").push(CATEGORY_WORLDGEN);
        setupWorldGenConfig();
        COMMON_BUILDER.pop();
        COMMON_BUILDER.comment("Fun Settings").push(CATEGORY_FUN);
        makeTrollConfig();
        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();
/*        CLIENT_CONFIG = CLIENT_BUILDER.build();*/
    }

    private static void setupWorldGenConfig(){
        ENABLE_WORLD_GEN = COMMON_BUILDER.comment("World Gen? [DEFAULT: true]")
                .define("worldgen_enabled", true);
    }

    private static void makeTrollConfig(){
        DISABLE_TROLL = COMMON_BUILDER.comment("Enable Troll? Note: Client Side only disables on Single Player - Server Side disables on Servers -- Info: ture means the trolling will work and false means trolling is disabled -- [DEFAULT: false]")
                .define("enable_troll", false);
        IS_APRIL_FOOLS_EVERYDAY = COMMON_BUILDER.comment("This Config enables the troll to run all year round! Enable at your own pearl -- enable_troll needs to be true for this to work -- [DEFAULT: false]")
                .define("make_it_april_fools_day", false);
    }
}
