package de.melanx.morexfood.datagen.handler;

import de.melanx.morexfood.util.Registry;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.CookingRecipeSerializer;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.Tag;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {

    public Recipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        registerSmeltingRecipes(consumer, "_smoking", IRecipeSerializer.SMOKING, 0.35F, 100);
        registerSmeltingRecipes(consumer, "_campfire", IRecipeSerializer.CAMPFIRE_COOKING, 0.35F, 600);

        registerSeedRecipe(Registry.agaricus.get(), Registry.agaricus_seed.get()).build(consumer);
        registerSeedRecipe(Registry.asparagus.get(), Registry.asparagus_seed.get()).build(consumer);
        registerSeedRecipe(Registry.peas.get(), Registry.peas_seed.get()).build(consumer);
        registerSeedRecipe(Registry.rice.get(), Registry.rice_seed.get()).build(consumer);

        registerPiecesRecipe(Registry.asparagus_pieces.get(), Registry.asparagus.get()).build(consumer);
        registerPiecesRecipe(Registry.carrot_pieces.get(), Items.CARROT).build(consumer);
        registerPiecesRecipe(Registry.chicken_pieces.get(), Items.CHICKEN).build(consumer);

        registerTwoIngredientRecipe(Registry.ice_cream.get(), Registry.ice_cubes.get(), Items.MILK_BUCKET).build(consumer);
        registerTwoIngredientRecipe(Registry.chicken_fricassee_rice.get(), Registry.rice.get(), Registry.chicken_fricassee.get()).build(consumer);
        registerTwoIngredientRecipe(Registry.mixed_vegetables.get(), Registry.carrot_pieces.get(), Registry.peas.get()).build(consumer);
        registerTwoIngredientRecipe(Registry.chicken_fricassee_rice_raw.get(), Registry.chicken_fricassee.get(), Registry.rice.get()).build(consumer, Registry.chicken_fricassee_rice_raw.get().getRegistryName() + "_simple");

        registerSixIngredientRecipe(Registry.chicken_fricassee_raw.get(), Registry.mixed_vegetables.get(), Registry.asparagus_pieces.get(), Registry.chicken_pieces.get(), Registry.dust_salt.get(), Items.WATER_BUCKET, Tags.Items.MUSHROOMS).build(consumer);
        registerSixIngredientRecipe(Registry.chicken_fricassee_special_raw.get(), Registry.carrot_pieces.get(), Registry.asparagus_pieces.get(), Registry.chicken_pieces.get(), Registry.rice.get(), Registry.dust_salt.get(), Items.WATER_BUCKET).build(consumer);

        registerSevenIngredientRecipe(Registry.chicken_fricassee_rice_raw.get(), Registry.mixed_vegetables.get(), Registry.asparagus_pieces.get(), Registry.chicken_pieces.get(), Registry.rice.get(), Registry.dust_salt.get(), Items.WATER_BUCKET, Tags.Items.MUSHROOMS).build(consumer, Registry.chicken_fricassee_rice_raw.get().getRegistryName() + "_complex");

        ShapedRecipeBuilder.shapedRecipe(Registry.knife.get())
                .key('s', Items.STICK)
                .key('i', Tags.Items.INGOTS_IRON)
                .patternLine("sss")
                .patternLine(" ii")
                .addCriterion("has_material", hasItem(Registry.knife.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(Registry.ice_cubes.get(), 8)
                .key('s', Items.SNOWBALL)
                .key('b', Items.POTION)
                .patternLine("sss")
                .patternLine("sbs")
                .patternLine("sss")
                .addCriterion("has_material", hasItem(Registry.ice_cubes.get())).build(consumer);
    }

    private void registerSmeltingRecipes(Consumer<IFinishedRecipe> consumer, String method, CookingRecipeSerializer<?> serializer, float xp, int time) {
        CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(Registry.chicken_fricassee_raw.get()), Registry.chicken_fricassee.get(), xp, time, serializer).addCriterion("has_raw", hasItem(Registry.chicken_fricassee_raw.get())).build(consumer, Registry.chicken_fricassee.get().getRegistryName() + method);
        CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(Registry.chicken_fricassee_rice_raw.get()), Registry.chicken_fricassee_rice.get(), xp, time, serializer).addCriterion("has_raw", hasItem(Registry.chicken_fricassee_rice_raw.get())).build(consumer, Registry.chicken_fricassee_rice.get().getRegistryName() + method);
        CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(Registry.chicken_fricassee_special_raw.get()), Registry.chicken_fricassee_special.get(), xp, time, serializer).addCriterion("has_raw", hasItem(Registry.chicken_fricassee_special_raw.get())).build(consumer, Registry.chicken_fricassee_special.get().getRegistryName() + method);
        CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(Registry.ice_cream.get()), Registry.ice_cream_baked.get(), xp, time, serializer).addCriterion("has_raw", hasItem(Registry.ice_cream.get())).build(consumer, Registry.ice_cream_baked.get().getRegistryName() + method);
        CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(Registry.horse_meat.get()), Registry.lasagne.get(), xp, time, serializer).addCriterion("has_raw", hasItem(Registry.horse_meat.get())).build(consumer, Registry.lasagne.get().getRegistryName() + method);
        CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(Registry.dog_goulash_raw.get()), Registry.dog_goulash.get(), xp, time, serializer).addCriterion("has_raw", hasItem(Registry.dog_goulash_raw.get())).build(consumer, Registry.dog_goulash.get().getRegistryName() + method);
    }

    private ShapelessRecipeBuilder registerSevenIngredientRecipe(Item result, Item ingredient1, Item ingredient2, Item ingredient3, Item ingredient4, Item ingredient5, Item ingredient6, Tag<Item> ingredient7) {
        return registerSixIngredientRecipe(result, ingredient1, ingredient2, ingredient3, ingredient4, ingredient5, ingredient7)
                .addIngredient(ingredient6);
    }

    private ShapelessRecipeBuilder registerSixIngredientRecipe(Item result, Item ingredient1, Item ingredient2, Item ingredient3, Item ingredient4, Item ingredient5, Tag<Item> ingredient6) {
        return ShapelessRecipeBuilder.shapelessRecipe(result)
                .addIngredient(ingredient1)
                .addIngredient(ingredient2)
                .addIngredient(ingredient3)
                .addIngredient(ingredient4)
                .addIngredient(ingredient5)
                .addIngredient(ingredient6)
                .addCriterion("has_material", hasItem(result));
    }

    private ShapelessRecipeBuilder registerSixIngredientRecipe(Item result, Item ingredient1, Item ingredient2, Item ingredient3, Item ingredient4, Item ingredient5, Item ingredient6) {
        return ShapelessRecipeBuilder.shapelessRecipe(result)
                .addIngredient(ingredient1)
                .addIngredient(ingredient2)
                .addIngredient(ingredient3)
                .addIngredient(ingredient4)
                .addIngredient(ingredient5)
                .addIngredient(ingredient6)
                .addCriterion("has_material", hasItem(result));
    }

    private ShapelessRecipeBuilder registerTwoIngredientRecipe(Item result, Item ingredient1, Item ingredient2) {
        return ShapelessRecipeBuilder.shapelessRecipe(result)
                .addIngredient(ingredient1)
                .addIngredient(ingredient2)
                .addCriterion("has_ingredient1", hasItem(ingredient1))
                .addCriterion("has_ingredient2", hasItem(ingredient2));
    }

    private ShapelessRecipeBuilder registerPiecesRecipe(Item result, Item ingredient) {
        return ShapelessRecipeBuilder.shapelessRecipe(result)
                .addIngredient(ingredient, 2)
                .addIngredient(Registry.knife.get())
                .addCriterion("has_food", hasItem(ingredient));
    }

    private ShapelessRecipeBuilder registerSeedRecipe(Item crop, Item seed) {
        return ShapelessRecipeBuilder.shapelessRecipe(seed)
                .addIngredient(crop)
                .addCriterion("has_item", hasItem(crop));
    }

}
