package net.manmaed.petrock.tag;

import net.manmaed.petrock.libs.RLHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class PRTags {

    public static final TagKey<Block> STONEIUM_ORES = createBlockTag("stoneium_ores");
    public static final TagKey<Item> RAW_MATERIALS_STONEIUM = createItemTag("raw_materials_stoneium");
    public static final TagKey<Item> PETROCK_FOOD = createItemTag("petrock_food");

    public static final TagKey<Item> PETROCK_STONE_VARIANT = createItemTag("petrock_stone_variant");
    public static final TagKey<Item> PETROCK_NETHER_VARIANT = createItemTag("petrock_nether_variant");
    public static final TagKey<Item> PETROCK_END_VARIANT = createItemTag("petrock_end_variant");
    public static final TagKey<Item> PETROCK_DEEPSLATE_VARIANT = createItemTag("petrock_deepslate_variant");
    public static final TagKey<Item> PETROCK_DIORITE_VARIANT = createItemTag("petrock_diorite_variant");
    public static final TagKey<Item> PETROCK_GRANITE_VARIANT = createItemTag("petrock_granite_variant");
    public static final TagKey<Item> PETROCK_ANDASITE_VARIANT = createItemTag("petrock_andasite_variant");
    public static final TagKey<Item> PETROCK_CLAY_VARIANT = createItemTag("petrock_clay_variant");
    public static final TagKey<Item> PETROCK_BEDROCK_VARIANT = createItemTag("petrock_bedrock_variant");
    public static final TagKey<Item> PETROCK_MISSINGNO_VARIANT = createItemTag("petrock_missingno_variant");

    /*
                name = "missingno";
                name = "diorite";
                name = "granite";
                name = "andesite";
                name = "clay";
                name = "bedrock";
     */

    private static TagKey<Block> createBlockTag(String name) {
        return TagKey.create(BuiltInRegistries.BLOCK.key(), RLHelper.location(name));
    }

    private static TagKey<Item> createItemTag(String name) {
        return TagKey.create(BuiltInRegistries.ITEM.key(), RLHelper.location(name));
    }
}
