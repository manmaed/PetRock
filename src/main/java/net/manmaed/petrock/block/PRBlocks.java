package net.manmaed.petrock.block;


import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.item.PRItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


/**
 * Created by manmaed on 26/11/2019.
 */
public class PRBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PetRock.MOD_ID);
            /**
             * Example Block:
             * public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of()));
             * public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = PRItems.ITEMS.register("example_block", () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties().tab(PetRock.itemGroup)));
             **/

    public static final DeferredBlock<Block> STONEIUM_ORE = BLOCKS.register("stoneium_ore", () -> new Block(BlockBehaviour.Properties.of().strength(3.0F).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DEEPSLATE_STONEIUM_ORE = BLOCKS.register("deepslate_stoneium_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(STONEIUM_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> STONEIUM_BLOCK = BLOCKS.register("stoneium_block", () -> new Block(BlockBehaviour.Properties.of().strength(3.0F).requiresCorrectToolForDrops()));

    public static final DeferredItem<Item> STONEIUM_ORE_ITEM = PRItems.ITEMS.register("stoneium_ore", () -> new BlockItem(STONEIUM_ORE.get(), new Item.Properties()));
    public static final DeferredItem<Item> DEEPSLATESTONEIUM_ORE_ITEM = PRItems.ITEMS.register("deepslate_stoneium_ore", () -> new BlockItem(DEEPSLATE_STONEIUM_ORE.get(), new Item.Properties()));

    public static final DeferredItem<Item> STONEIUM_BLOCK_ITEM = PRItems.ITEMS.register("stoneium_block", () -> new BlockItem(STONEIUM_BLOCK.get(), new Item.Properties()));

}
/*
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Refs.id);
    public static final RegistryObject<Feature<OreFeatureConfig>> STONEIUMOREFEATURES = FEATURES.register("stoneiumfeature", () -> new StoneiumOreFeature(OreFeatureConfig.CODEC));
*/
