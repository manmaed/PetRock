package net.manmaed.petrock.blocks;


import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.items.PRItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Created by manmaed on 26/11/2019.
 */
public class PRBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PetRock.MOD_ID);
            /**
             * Example Block:
             * public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)));
             * public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = PRItems.ITEMS.register("example_block", () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties().tab(PetRock.itemGroup)));
             **/

    public static final RegistryObject<Block> STONEIUM_ORE = BLOCKS.register("stoneium_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> STONEIUM_BLOCK = BLOCKS.register("stoneium_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3.0F).requiresCorrectToolForDrops()));

    public static final RegistryObject<Item> STONEIUM_ORE_ITEM = PRItems.ITEMS.register("stoneium_ore", () -> new BlockItem(STONEIUM_ORE.get(), new Item.Properties().tab(PetRock.itemGroup)));
    public static final RegistryObject<Item> STONEIUM_BLOCK_ITEM = PRItems.ITEMS.register("stoneium_block", () -> new BlockItem(STONEIUM_BLOCK.get(), new Item.Properties().tab(PetRock.itemGroup)));

}
/*
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Refs.id);
    public static final RegistryObject<Feature<OreFeatureConfig>> STONEIUMOREFEATURES = FEATURES.register("stoneiumfeature", () -> new StoneiumOreFeature(OreFeatureConfig.CODEC));
*/
