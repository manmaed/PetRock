package net.manmaed.petrock.jade;

import net.manmaed.petrock.libs.RLHelper;
import net.minecraft.resources.ResourceLocation;

/**
 * Made by manmaed on 25/10/2025
 */

public interface PRJadeIds {

    ResourceLocation PETROCK_STATS = PR("petrock_stats");

    static ResourceLocation PR(String path) { return ResourceLocation.fromNamespaceAndPath("petrock",path); }
}
