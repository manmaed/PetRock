package net.manmaed.petrock.entity;

import net.manmaed.petrock.libs.RLHelper;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

/**
 * Copy & Paste form {@link net.minecraft.world.entity.animal.CatVariant}
 */
public record RockVariant(ResourceLocation texture) {
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<RockVariant>> STREAM_CODEC = ByteBufCodecs.holderRegistry(PREntityTypes.ROCK_VARIANT);
    public static final ResourceKey<RockVariant> STONE = createKey("stone");

    public static RockVariant bootstrap(Registry<RockVariant> rockVariants) {
        return register(rockVariants, STONE, "stone");
    }
    private static ResourceKey<RockVariant> createKey(String name) {
        return ResourceKey.create(PREntityTypes.ROCK_VARIANT, RLHelper.location(name));
    }
    private static RockVariant register(Registry<RockVariant> rockVariantRegistry, ResourceKey<RockVariant> rockVariantResourceKey, String name) {
        return Registry.register(rockVariantRegistry, rockVariantResourceKey, new RockVariant(RLHelper.location("textures/entity/petrock/" + name + ".png")));
    }
}
