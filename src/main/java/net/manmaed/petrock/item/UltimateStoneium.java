package net.manmaed.petrock.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class UltimateStoneium extends Item {
    public UltimateStoneium() {
        super(new Properties().component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext tooltipContext, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.translatable(getDescriptionId() +  ".tooltip"));
    }
}
