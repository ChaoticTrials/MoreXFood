package de.melanx.morexfood.datagen.handler;

import blusunrize.immersiveengineering.api.crafting.ClocheRenderFunction;
import blusunrize.immersiveengineering.api.crafting.builders.ClocheRecipeBuilder;
import de.melanx.morexfood.MoreXFood;
import de.melanx.morexfood.items.ModSeed;
import de.melanx.morexfood.util.ModRegistration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Recipes extends RecipeProvider {

    public Recipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(@Nonnull Consumer<FinishedRecipe> consumer) {
        this.registerSmeltingRecipes(consumer, "_smoking", RecipeSerializer.SMOKING_RECIPE, 0.35F, 100);
        this.registerSmeltingRecipes(consumer, "_campfire", RecipeSerializer.CAMPFIRE_COOKING_RECIPE, 0.35F, 600);
        this.registerSmeltingRecipes(consumer, "_smelting", RecipeSerializer.SMELTING_RECIPE, 0.35F, 200);

        for (RegistryObject<Item> entry : ModRegistration.SEEDS.getEntries()) {
            Item seed = entry.get();
            Block crop = ((ModSeed) seed).getCrop();
            this.registerSeedRecipe(crop, seed).save(consumer);
            //noinspection ConstantConditions
            this.registerClocheRecipe(crop.asItem(), seed, crop).build(consumer, new ResourceLocation(MoreXFood.MODID, "cloche/" + crop.getRegistryName().getPath()));
        }

        this.registerPiecesRecipe(ModRegistration.asparagus_pieces.get(), ModRegistration.asparagus.get()).save(consumer);
        this.registerPiecesRecipe(ModRegistration.carrot_pieces.get(), Items.CARROT).save(consumer);
        this.registerPiecesRecipe(ModRegistration.chicken_pieces.get(), Items.CHICKEN).save(consumer);

        this.registerShapelessRecipe(ModRegistration.ice_cream.get(), null, Arrays.asList(ModRegistration.ice_cubes.get(), Items.MILK_BUCKET)).save(consumer);
        this.registerShapelessRecipe(ModRegistration.chicken_fricassee_rice.get(), null, Arrays.asList(ModRegistration.rice.get(), ModRegistration.chicken_fricassee.get())).save(consumer);
        this.registerShapelessRecipe(ModRegistration.mixed_vegetables.get(), null, Arrays.asList(ModRegistration.carrot_pieces.get(), ModRegistration.peas.get())).save(consumer);
        this.registerShapelessRecipe(ModRegistration.chicken_fricassee_rice_raw.get(), null, Arrays.asList(ModRegistration.chicken_fricassee.get(), ModRegistration.rice.get())).save(consumer, ModRegistration.chicken_fricassee_rice_raw.get().getRegistryName() + "_simple");

        this.registerShapelessRecipe(ModRegistration.chicken_fricassee_raw.get(), Collections.singletonList(Tags.Items.MUSHROOMS), Arrays.asList(ModRegistration.mixed_vegetables.get(), ModRegistration.asparagus_pieces.get(), ModRegistration.chicken_pieces.get(), ModRegistration.dust_salt.get(), Items.WATER_BUCKET)).save(consumer);
        this.registerShapelessRecipe(ModRegistration.chicken_fricassee_special_raw.get(), null, Arrays.asList(ModRegistration.carrot_pieces.get(), ModRegistration.asparagus_pieces.get(), ModRegistration.chicken_pieces.get(), ModRegistration.rice.get(), ModRegistration.dust_salt.get(), Items.WATER_BUCKET)).save(consumer);

        this.registerShapelessRecipe(ModRegistration.chicken_fricassee_rice_raw.get(), Collections.singletonList(Tags.Items.MUSHROOMS), Arrays.asList(ModRegistration.mixed_vegetables.get(), ModRegistration.asparagus_pieces.get(), ModRegistration.chicken_pieces.get(), ModRegistration.rice.get(), ModRegistration.dust_salt.get(), Items.WATER_BUCKET)).save(consumer, ModRegistration.chicken_fricassee_rice_raw.get().getRegistryName() + "_complex");

        ShapedRecipeBuilder.shaped(ModRegistration.knife.get())
                .define('s', Items.STICK)
                .define('i', Tags.Items.INGOTS_IRON)
                .pattern("sss")
                .pattern(" ii")
                .unlockedBy("has_material", has(ModRegistration.knife.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModRegistration.ice_cubes.get(), 8)
                .define('s', Items.SNOWBALL)
                .define('b', Items.POTION)
                .pattern("sss")
                .pattern("sbs")
                .pattern("sss")
                .unlockedBy("has_material", has(ModRegistration.ice_cubes.get())).save(consumer);
    }

    @SuppressWarnings("SameParameterValue")
    private void registerSmeltingRecipes(Consumer<FinishedRecipe> consumer, String method, SimpleCookingSerializer<?> serializer, float xp, int time) {
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(ModRegistration.chicken_fricassee_raw.get()), ModRegistration.chicken_fricassee.get(), xp, time, serializer).unlockedBy("has_raw", has(ModRegistration.chicken_fricassee_raw.get())).save(consumer, ModRegistration.chicken_fricassee.get().getRegistryName() + method);
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(ModRegistration.chicken_fricassee_rice_raw.get()), ModRegistration.chicken_fricassee_rice.get(), xp, time, serializer).unlockedBy("has_raw", has(ModRegistration.chicken_fricassee_rice_raw.get())).save(consumer, ModRegistration.chicken_fricassee_rice.get().getRegistryName() + method);
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(ModRegistration.chicken_fricassee_special_raw.get()), ModRegistration.chicken_fricassee_special.get(), xp, time, serializer).unlockedBy("has_raw", has(ModRegistration.chicken_fricassee_special_raw.get())).save(consumer, ModRegistration.chicken_fricassee_special.get().getRegistryName() + method);
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(ModRegistration.ice_cream.get()), ModRegistration.ice_cream_baked.get(), xp, time, serializer).unlockedBy("has_raw", has(ModRegistration.ice_cream.get())).save(consumer, ModRegistration.ice_cream_baked.get().getRegistryName() + method);
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(ModRegistration.horse_meat.get()), ModRegistration.lasagne.get(), xp, time, serializer).unlockedBy("has_raw", has(ModRegistration.horse_meat.get())).save(consumer, ModRegistration.lasagne.get().getRegistryName() + method);
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(ModRegistration.dog_goulash_raw.get()), ModRegistration.dog_goulash.get(), xp, time, serializer).unlockedBy("has_raw", has(ModRegistration.dog_goulash_raw.get())).save(consumer, ModRegistration.dog_goulash.get().getRegistryName() + method);
    }


    private ShapelessRecipeBuilder registerShapelessRecipe(ItemLike result, List<Tag.Named<Item>> tagIngredients, List<Item> ingredients) {
        ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(result);
        if (tagIngredients != null)
            for (Tag.Named<Item> tag : tagIngredients) {
                builder.requires(Ingredient.of(tag));
            }
        if (ingredients != null)
            for (Item item : ingredients) {
                builder.requires(Ingredient.of(item));
            }
        return builder.unlockedBy("has_material", has(result));
    }

    private ShapelessRecipeBuilder registerPiecesRecipe(ItemLike result, ItemLike ingredient) {
        return ShapelessRecipeBuilder.shapeless(result)
                .requires(ingredient)
                .requires(ModRegistration.knife.get())
                .unlockedBy("has_food", has(ingredient));
    }

    private ShapelessRecipeBuilder registerSeedRecipe(ItemLike crop, ItemLike seed) {
        return ShapelessRecipeBuilder.shapeless(seed)
                .requires(crop)
                .unlockedBy("has_item", has(crop));
    }

    private ClocheRecipeBuilder registerClocheRecipe(Item crop, Item seed, Block cropBlock) {
        return ClocheRecipeBuilder.builder(new ItemStack(crop, 2))
                .addResult(seed)
                .addInput(seed)
                .addSoil(Blocks.DIRT)
                .setTime(640)
                .setRender(new ClocheRenderFunction.ClocheRenderReference("crop", cropBlock));
    }
}
