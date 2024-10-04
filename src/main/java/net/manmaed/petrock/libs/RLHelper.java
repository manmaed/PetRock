package net.manmaed.petrock.libs;

import net.manmaed.petrock.PetRock;
import net.minecraft.resources.ResourceLocation;

public class RLHelper {
    public static ResourceLocation location(String location) {
        return ResourceLocation.fromNamespaceAndPath(PetRock.MOD_ID, location);
    }
}
