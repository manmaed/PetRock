package net.manmaed.petrock.tab;

import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.item.PRItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Arrays;
import java.util.List;

public class PRTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PetRock.MOD_ID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> PETSLOW_TAB = CREATIVE_TABS.register(PetRock.MOD_ID, () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(PRItems.PETROCKBOX.get()))
            .title(Component.translatable("itemGroup." + PetRock.MOD_ID ))
            .displayItems((parameters, output) -> {
                List<DeferredRegister<Item>> myItems = Arrays.asList(
                        PRItems.ITEMS
                );
                for (DeferredRegister<Item> register: myItems) {
                    register.getEntries().forEach(entry -> output.accept(entry.get()));
                }
            })
            .build());
}