package de.melanx.morexfood.datagen.handler;

import de.melanx.morexfood.util.IModSeed;
import de.melanx.morexfood.util.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fmllegacy.RegistryObject;

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

        for (RegistryObject<Item> entry : Registry.SEEDS.getEntries()) {
            Item seed = entry.get();
            Item crop = ((IModSeed) seed).getCrop();
            Block cropBlock = ((IModSeed) seed).getCropBlock();
            this.registerSeedRecipe(crop, seed).save(consumer);
            // TODO re-add when IE is ported
//            registerClocheRecipe(crop, seed, cropBlock).build(consumer, new ResourceLocation(MoreXFood.MODID, "cloche/" + crop.getRegistryName().getPath()));
        }

        this.registerPiecesRecipe(Registry.asparagus_pieces.get(), Registry.asparagus.get()).save(consumer);
        this.registerPiecesRecipe(Registry.carrot_pieces.get(), Items.CARROT).save(consumer);
        this.registerPiecesRecipe(Registry.chicken_pieces.get(), Items.CHICKEN).save(consumer);

        this.registerShapelessRecipe(Registry.ice_cream.get(), null, Arrays.asList(Registry.ice_cubes.get(), Items.MILK_BUCKET)).save(consumer);
        this.registerShapelessRecipe(Registry.chicken_fricassee_rice.get(), null, Arrays.asList(Registry.rice.get(), Registry.chicken_fricassee.get())).save(consumer);
        this.registerShapelessRecipe(Registry.mixed_vegetables.get(), null, Arrays.asList(Registry.carrot_pieces.get(), Registry.peas.get())).save(consumer);
        this.registerShapelessRecipe(Registry.chicken_fricassee_rice_raw.get(), null, Arrays.asList(Registry.chicken_fricassee.get(), Registry.rice.get())).save(consumer, Registry.chicken_fricassee_rice_raw.get().getRegistryName() + "_simple");

        this.registerShapelessRecipe(Registry.chicken_fricassee_raw.get(), Collections.singletonList(Tags.Items.MUSHROOMS), Arrays.asList(Registry.mixed_vegetables.get(), Registry.asparagus_pieces.get(), Registry.chicken_pieces.get(), Registry.dust_salt.get(), Items.WATER_BUCKET)).save(consumer);
        this.registerShapelessRecipe(Registry.chicken_fricassee_special_raw.get(), null, Arrays.asList(Registry.carrot_pieces.get(), Registry.asparagus_pieces.get(), Registry.chicken_pieces.get(), Registry.rice.get(), Registry.dust_salt.get(), Items.WATER_BUCKET)).save(consumer);

        this.registerShapelessRecipe(Registry.chicken_fricassee_rice_raw.get(), Collections.singletonList(Tags.Items.MUSHROOMS), Arrays.asList(Registry.mixed_vegetables.get(), Registry.asparagus_pieces.get(), Registry.chicken_pieces.get(), Registry.rice.get(), Registry.dust_salt.get(), Items.WATER_BUCKET)).save(consumer, Registry.chicken_fricassee_rice_raw.get().getRegistryName() + "_complex");

        ShapedRecipeBuilder.shaped(Registry.knife.get())
                .define('s', Items.STICK)
                .define('i', Tags.Items.INGOTS_IRON)
                .pattern("sss")
                .pattern(" ii")
                .unlockedBy("has_material", has(Registry.knife.get())).save(consumer);

        ShapedRecipeBuilder.shaped(Registry.ice_cubes.get(), 8)
                .define('s', Items.SNOWBALL)
                .define('b', Items.POTION)
                .pattern("sss")
                .pattern("sbs")
                .pattern("sss")
                .unlockedBy("has_material", has(Registry.ice_cubes.get())).save(consumer);
    }

    @SuppressWarnings("SameParameterValue")
    private void registerSmeltingRecipes(Consumer<FinishedRecipe> consumer, String method, SimpleCookingSerializer<?> serializer, float xp, int time) {
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(Registry.chicken_fricassee_raw.get()), Registry.chicken_fricassee.get(), xp, time, serializer).unlockedBy("has_raw", has(Registry.chicken_fricassee_raw.get())).save(consumer, Registry.chicken_fricassee.get().getRegistryName() + method);
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(Registry.chicken_fricassee_rice_raw.get()), Registry.chicken_fricassee_rice.get(), xp, time, serializer).unlockedBy("has_raw", has(Registry.chicken_fricassee_rice_raw.get())).save(consumer, Registry.chicken_fricassee_rice.get().getRegistryName() + method);
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(Registry.chicken_fricassee_special_raw.get()), Registry.chicken_fricassee_special.get(), xp, time, serializer).unlockedBy("has_raw", has(Registry.chicken_fricassee_special_raw.get())).save(consumer, Registry.chicken_fricassee_special.get().getRegistryName() + method);
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(Registry.ice_cream.get()), Registry.ice_cream_baked.get(), xp, time, serializer).unlockedBy("has_raw", has(Registry.ice_cream.get())).save(consumer, Registry.ice_cream_baked.get().getRegistryName() + method);
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(Registry.horse_meat.get()), Registry.lasagne.get(), xp, time, serializer).unlockedBy("has_raw", has(Registry.horse_meat.get())).save(consumer, Registry.lasagne.get().getRegistryName() + method);
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(Registry.dog_goulash_raw.get()), Registry.dog_goulash.get(), xp, time, serializer).unlockedBy("has_raw", has(Registry.dog_goulash_raw.get())).save(consumer, Registry.dog_goulash.get().getRegistryName() + method);
    }


    private ShapelessRecipeBuilder registerShapelessRecipe(Item result, List<Tag.Named<Item>> tagIngredients, List<Item> ingredients) {
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

    private ShapelessRecipeBuilder registerPiecesRecipe(Item result, Item ingredient) {
        return ShapelessRecipeBuilder.shapeless(result)
                .requires(ingredient)
                .requires(Registry.knife.get())
                .unlockedBy("has_food", has(ingredient));
    }

    private ShapelessRecipeBuilder registerSeedRecipe(Item crop, Item seed) {
        return ShapelessRecipeBuilder.shapeless(seed)
                .requires(crop)
                .unlockedBy("has_item", has(crop));
    }

//    private ClocheRecipeBuilder registerClocheRecipe(Item crop, Item seed, Block cropBlock) {
//        return ClocheRecipeBuilder.builder(new ItemStack(crop, 2))
//                .addResult(seed)
//                .addInput(seed)
//                .addSoil(Blocks.DIRT)
//                .setTime(640)
//                .setRender(new ClocheRenderFunction.ClocheRenderReference("crop", cropBlock));
//    }
}
