package net.manmaed.petrock.items;

import net.manmaed.petrock.PetRock;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Created by manmaed on 25/11/2019.
 */
public class PRItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PetRock.MOD_ID);

    /**
     * Example Item:
     * public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new Item.Properties().tab(PetRock.itemGroup)));
     **/
    public static final RegistryObject<Item> STONEIUM = ITEMS.register("stoneium", () -> new Stoneium(new Item.Properties().tab(PetRock.itemGroup)));
    public static final RegistryObject<Item> KIBBLE = ITEMS.register("kibble", () -> new Kibble(new Item.Properties().tab(PetRock.itemGroup)));
    public static final RegistryObject<Item> ORDER_FORM = ITEMS.register("orderform", () -> new OrderForm(new Item.Properties().tab(PetRock.itemGroup)));
    public static final RegistryObject<Item> PETROCKBOX = ITEMS.register("petrockbox", () -> new PetRockBox(new Item.Properties().tab(PetRock.itemGroup)));
    public static final RegistryObject<Item> PETROCKWITHLEGSBOX = ITEMS.register("petrockwithlegsbox", () -> new PetRockWithLegsBox(new Item.Properties().tab(PetRock.itemGroup)));
    public static final RegistryObject<Item> STONE_LEGS = ITEMS.register("stone_legs", () -> new StoneLegs(new Item.Properties().tab(PetRock.itemGroup)));

}
