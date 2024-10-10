package net.manmaed.petrock.tag;

import net.manmaed.petrock.libs.RLHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class PRTags {

    public static final TagKey<Block> STONEIUM_ORES = create("stoneium_ores");

    private static TagKey<Block> create(String name) {
        return TagKey.create(BuiltInRegistries.BLOCK.key(), RLHelper.location(name));
    }
}
