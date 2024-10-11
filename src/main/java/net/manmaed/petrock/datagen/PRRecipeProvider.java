package net.manmaed.petrock.datagen;

import net.manmaed.petrock.block.PRBlocks;
import net.manmaed.petrock.item.PRItems;
import net.manmaed.petrock.libs.RLHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import vazkii.patchouli.api.PatchouliAPI;

import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PRRecipeProvider extends RecipeProvider {
    private static final RecipeCategory misc = RecipeCategory.MISC;
    private static final RecipeCategory block = RecipeCategory.BUILDING_BLOCKS;
    private static final RecipeCategory food = RecipeCategory.FOOD;

    public PRRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(packOutput, completableFuture);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ShapedRecipeBuilder.shaped(food, PRItems.KIBBLE.get())
                .define('m', Ingredient.of(Blocks.STONE.asItem()))
                .define('s', Ingredient.of(PRItems.STONEIUM.get()))
                .define('c', Ingredient.of(Items.COOKIE))
                .pattern("msm")
                .pattern("scs")
                .pattern("msm").unlockedBy("has_cookie", has(Items.COOKIE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(misc, PRItems.ORDER_FORM.get())
                .define('p', Ingredient.of(Items.PAPER))
                .define('i', Ingredient.of(Items.INK_SAC))
                .pattern("ppp")
                .pattern("pip")
                .pattern("ppp").unlockedBy("has_ink", has(Items.INK_SAC)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(misc, PRItems.STONE_LEGS.get())
                .define('s', Ingredient.of(Blocks.STONE.asItem()))
                .pattern("s s")
                .pattern("s s").unlockedBy("has_stone", has(Blocks.STONE.asItem())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(misc, PRItems.PETROCKWITHLEGSBOX.get())
                .requires(PRItems.PETROCKBOX.get())
                .requires(PRItems.STONE_LEGS).unlockedBy("has_stone_legs", has(PRItems.STONE_LEGS.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(misc, PRItems.STONEIUM.get(), 9)
                .requires(PRBlocks.STONEIUM_BLOCK.get()).unlockedBy("has_stoneium_ingot", has(PRItems.STONEIUM.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(block, PRBlocks.STONEIUM_BLOCK.get())
                .define('s', Ingredient.of(PRItems.STONEIUM.get()))
                .pattern("sss")
                .pattern("sss")
                .pattern("sss").unlockedBy("has_stoneium_ingot", has(PRItems.STONEIUM.get())).save(recipeOutput);


        oreToIngot(PRBlocks.STONEIUM_ORE.get(), PRItems.STONEIUM.get(), recipeOutput);
        oreToIngot(PRBlocks.DEEPSLATE_STONEIUM_ORE.get(), PRItems.STONEIUM.get(), recipeOutput);

        ingotToIngot(PRItems.RAW_STONEIUM.get(), PRItems.STONEIUM.get(), recipeOutput);
        ShapelessRecipeBuilder.shapeless(misc, PatchouliAPI.get().getBookStack(RLHelper.location("petrock_care_guide")))
                .requires(Items.BOOK).requires(PRItems.STONEIUM).unlockedBy("has_stoneium_ingot", has(PRItems.STONEIUM)).save(recipeOutput, "patchouli:petrock_care_guide");
    }

    private static void ingotToIngot(Item rawore, Item ingot, RecipeOutput recipeOutput) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(rawore), misc, ingot, 0.7F, 100).unlockedBy(getHasName(rawore), has(rawore)).save(recipeOutput, RLHelper.location(retunName(ingot) + "_from_blasting_" + retunName(rawore)));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(rawore), misc, ingot, 0.7F, 200).unlockedBy(getHasName(rawore), has(rawore)).save(recipeOutput, RLHelper.location(retunName(ingot) + "_from_smelting_" + retunName(rawore)));
    }
    private static void oreToIngot(Block ore, Item ingot, RecipeOutput recipeOutput) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ore), misc, ingot, 0.7F, 100).unlockedBy(getHasName(ore), has(ore)).save(recipeOutput, RLHelper.location(retunName(ingot) + "_from_blasting_" + retunName(ore.asItem())));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ore), misc, ingot, 0.7F, 200).unlockedBy(getHasName(ore), has(ore)).save(recipeOutput, RLHelper.location(retunName(ingot) + "_from_smelting_" + retunName(ore.asItem())));
    }

    private static String retunName(Item item) {
        String item_with_idet = item.toString();
        String regex = "(?<=:)[^:]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(item_with_idet);
        // Extract the part after the colon
        String name = ""; //Should always be replaced
        if (matcher.find()) {
            name = matcher.group();
        }
        return name;
    }
}
