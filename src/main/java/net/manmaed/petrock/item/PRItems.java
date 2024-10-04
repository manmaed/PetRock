package net.manmaed.petrock.item;

import net.manmaed.petrock.PetRock;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Created by manmaed on 25/11/2019.
 */
public class PRItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PetRock.MOD_ID);

    /**
     * Example Item:
     * public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new Item.Properties()));
     **/
    public static final DeferredItem<Item> STONEIUM = ITEMS.register("stoneium", () -> new Stoneium(new Item.Properties()));
    public static final DeferredItem<Item> KIBBLE = ITEMS.register("kibble", () -> new Kibble(new Item.Properties()));
    public static final DeferredItem<Item> ORDER_FORM = ITEMS.register("orderform", () -> new OrderForm(new Item.Properties()));
    public static final DeferredItem<Item> PETROCKBOX = ITEMS.register("petrockbox", () -> new PetRockBox(new Item.Properties()));
    public static final DeferredItem<Item> PETROCKWITHLEGSBOX = ITEMS.register("petrockwithlegsbox", () -> new PetRockWithLegsBox(new Item.Properties()));
    public static final DeferredItem<Item> STONE_LEGS = ITEMS.register("stone_legs", () -> new StoneLegs(new Item.Properties()));

}
