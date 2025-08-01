package net.manmaed.petrock.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class PRItemWithTooltip extends Item {

    public PRItemWithTooltip() {
        super(new Item.Properties());
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext tooltipContext, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.translatable(getDescriptionId() +  ".tooltip"));
    }

}
