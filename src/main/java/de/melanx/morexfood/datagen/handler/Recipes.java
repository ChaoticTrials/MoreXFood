package de.melanx.morexfood.datagen.handler;

import blusunrize.immersiveengineering.api.crafting.ClocheRenderFunction;
import blusunrize.immersiveengineering.api.crafting.builders.ClocheRecipeBuilder;
import de.melanx.morexfood.util.IModSeed;
import de.melanx.morexfood.util.Registry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.CookingRecipeSerializer;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fml.RegistryObject;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Recipes extends RecipeProvider {

    public Recipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        registerSmeltingRecipes(consumer, "_smoking", IRecipeSerializer.SMOKING, 0.35F, 100);
        registerSmeltingRecipes(consumer, "_campfire", IRecipeSerializer.CAMPFIRE_COOKING, 0.35F, 600);
        registerSmeltingRecipes(consumer, "_smelting", IRecipeSerializer.SMELTING, 0.35F, 200);

        for (RegistryObject<Item> entry : Registry.SEEDS.getEntries()) {
            Item seed = entry.get();
            Item crop = ((IModSeed) seed).getCrop();
            Block cropBlock = ((IModSeed) seed).getCropBlock();
            registerSeedRecipe(crop, seed).build(consumer);
            registerClocheRecipe(crop, seed, cropBlock).build(consumer, new ResourceLocation("immersiveengineering", "cloche/" + crop.getRegistryName().getPath()));
        }

        registerPiecesRecipe(Registry.asparagus_pieces.get(), Registry.asparagus.get()).build(consumer);
        registerPiecesRecipe(Registry.carrot_pieces.get(), Items.CARROT).build(consumer);
        registerPiecesRecipe(Registry.chicken_pieces.get(), Items.CHICKEN).build(consumer);

        registerShapelessRecipe(Registry.ice_cream.get(), null, Arrays.asList(Registry.ice_cubes.get(), Items.MILK_BUCKET)).build(consumer);
        registerShapelessRecipe(Registry.chicken_fricassee_rice.get(), null, Arrays.asList(Registry.rice.get(), Registry.chicken_fricassee.get())).build(consumer);
        registerShapelessRecipe(Registry.mixed_vegetables.get(), null, Arrays.asList(Registry.carrot_pieces.get(), Registry.peas.get())).build(consumer);
        registerShapelessRecipe(Registry.chicken_fricassee_rice_raw.get(), null, Arrays.asList(Registry.chicken_fricassee.get(), Registry.rice.get())).build(consumer, Registry.chicken_fricassee_rice_raw.get().getRegistryName() + "_simple");

        registerShapelessRecipe(Registry.chicken_fricassee_raw.get(), Collections.singletonList(Tags.Items.MUSHROOMS), Arrays.asList(Registry.mixed_vegetables.get(), Registry.asparagus_pieces.get(), Registry.chicken_pieces.get(), Registry.dust_salt.get(), Items.WATER_BUCKET)).build(consumer);
        registerShapelessRecipe(Registry.chicken_fricassee_special_raw.get(), null, Arrays.asList(Registry.carrot_pieces.get(), Registry.asparagus_pieces.get(), Registry.chicken_pieces.get(), Registry.rice.get(), Registry.dust_salt.get(), Items.WATER_BUCKET)).build(consumer);

        registerShapelessRecipe(Registry.chicken_fricassee_rice_raw.get(), Collections.singletonList(Tags.Items.MUSHROOMS), Arrays.asList(Registry.mixed_vegetables.get(), Registry.asparagus_pieces.get(), Registry.chicken_pieces.get(), Registry.rice.get(), Registry.dust_salt.get(), Items.WATER_BUCKET)).build(consumer, Registry.chicken_fricassee_rice_raw.get().getRegistryName() + "_complex");

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

    private ShapelessRecipeBuilder registerShapelessRecipe(Item result, List<Tag<Item>> tagIngredients, List<Item> ingredients) {
        ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapelessRecipe(result);
        if (tagIngredients != null)
            for (Tag<Item> tag : tagIngredients) {
                builder.addIngredient(Ingredient.fromTag(tag));
            }
        if (ingredients != null)
            for (Item item : ingredients) {
                builder.addIngredient(Ingredient.fromItems(item));
            }
        return builder.addCriterion("has_material", hasItem(result));
    }

    private ShapelessRecipeBuilder registerPiecesRecipe(Item result, Item ingredient) {
        return ShapelessRecipeBuilder.shapelessRecipe(result)
                .addIngredient(ingredient)
                .addIngredient(Registry.knife.get())
                .addCriterion("has_food", hasItem(ingredient));
    }

    private ShapelessRecipeBuilder registerSeedRecipe(Item crop, Item seed) {
        return ShapelessRecipeBuilder.shapelessRecipe(seed)
                .addIngredient(crop)
                .addCriterion("has_item", hasItem(crop));
    }

    private ClocheRecipeBuilder registerClocheRecipe(Item crop, Item seed, Block cropBlock) {
        return ClocheRecipeBuilder.builder(new ItemStack(crop, 2))
                .addInput(seed)
                .addSoil(Blocks.DIRT)
                .setTime(640)
                .setRender(new ClocheRenderFunction.ClocheRenderReference("crop", cropBlock));
    }

}
