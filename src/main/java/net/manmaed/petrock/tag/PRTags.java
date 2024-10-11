package net.manmaed.petrock.tag;

import net.manmaed.petrock.libs.RLHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class PRTags {

    public static final TagKey<Block> STONEIUM_ORES = createBlockTag("stoneium_ores");
    public static final TagKey<Item> RAW_MATERIALS_STONEIUM = createItemTag("raw_materials_stoneium");

    private static TagKey<Block> createBlockTag(String name) {
        return TagKey.create(BuiltInRegistries.BLOCK.key(), RLHelper.location(name));
    }

    private static TagKey<Item> createItemTag(String name) {
        return TagKey.create(BuiltInRegistries.ITEM.key(), RLHelper.location(name));
    }
}
