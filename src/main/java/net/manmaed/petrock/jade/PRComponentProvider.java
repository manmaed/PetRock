package net.manmaed.petrock.jade;

import net.manmaed.petrock.entity.EntityPetRock;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.EntityAccessor;
import snownee.jade.api.IEntityComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

/**
 * Made by manmaed on 25/10/2025
 */

public enum PRComponentProvider implements IEntityComponentProvider, IServerDataProvider<EntityAccessor> {
    INSTANCE;

    @Override
    public void appendTooltip(ITooltip tooltip, EntityAccessor entityAccessor, IPluginConfig iPluginConfig) {
        /*EntityPetRock petRock = (EntityPetRock) entityAccessor.getEntity()*/;
        if (entityAccessor.getServerData().contains("Variant")) {
            tooltip.add(Component.translatable("petrock.entity.petrock.variant", entityAccessor.getServerData().getString("Variant")));
        }
        if (entityAccessor.getServerData().contains("Hat")) {
            if(entityAccessor.getServerData().getString("Hat").isEmpty()) {
                tooltip.add(Component.translatable("petrock.entity.petrock.hat_data.notset"));
            } else {
                tooltip.add(Component.translatable("petrock.entity.petrock.hat_data", entityAccessor.getServerData().getString("Hat")));
            }
        }
        if (entityAccessor.getServerData().contains("Slowpoke")) {
            if (entityAccessor.getServerData().getString("Hat").isEmpty()) {

            } else {
                tooltip.add(Component.translatable("petrock.entity.petrock.is_slowpoke", entityAccessor.getServerData().getString("Slowpoke")));
            }
        }
    }

    @Override
    public ResourceLocation getUid() {
        return PRJadeIds.PETROCK_STATS;
    }

    @Override
    public void appendServerData(CompoundTag compoundTag, EntityAccessor entityAccessor) {
        EntityPetRock petRock = (EntityPetRock) entityAccessor.getEntity();
        compoundTag.putString("Variant", petRock.getVariantName());
        compoundTag.putString("Hat", petRock.getHatData());
        compoundTag.putString("Slowpoke", petRock.getSlowpoke().toString());
    }
}
