package de.melanx.morexfood.util;

import de.melanx.morexfood.MoreXFood;
import de.melanx.morexfood.block.*;
import de.melanx.morexfood.items.ContainerItem;
import de.melanx.morexfood.items.ModSeed;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static de.melanx.morexfood.MoreXFood.MODID;

public class ModRegistration {

    private static final Block.Properties BLOCK_PROPS = Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.CROP);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<Item> FOOD = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<Item> SEEDS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    // blocks
    public static final RegistryObject<Block> salt_ore = BLOCKS.register("salt_ore", OreSalt::new);
    public static final RegistryObject<Block> agaricus_block = BLOCKS.register("crop_agaricus", () -> new BlockCropAgaricus(BLOCK_PROPS));
    public static final RegistryObject<Block> asparagus_block = BLOCKS.register("crop_asparagus", () -> new BlockCropAsparagus(BLOCK_PROPS));
    public static final RegistryObject<Block> peas_block = BLOCKS.register("crop_peas", () -> new BlockCropPea(BLOCK_PROPS));
    public static final RegistryObject<Block> rice_block = BLOCKS.register("crop_rice", () -> new BlockCropRice(BLOCK_PROPS));
    public static final RegistryObject<Item> salt_ore_item = BLOCK_ITEMS.register("salt_ore", () -> new BlockItem(salt_ore.get(), ModRegistration.itemProps()));

    // items
    public static final RegistryObject<Item> knife = ITEMS.register("knife", () -> new ContainerItem(ModRegistration.itemProps()));
    public static final RegistryObject<Item> ice_cubes = ITEMS.register("ice_cubes", () -> new Item(ModRegistration.itemProps()));
    public static final RegistryObject<Item> dust_salt = ITEMS.register("salt", () -> new Item(ModRegistration.itemProps()));

    // food
    public static final RegistryObject<Item> agaricus = FOOD.register("agaricus", () -> new Item(ModRegistration.itemProps().food(buildFoodValues(1, 0.6F))));
    public static final RegistryObject<Item> asparagus = FOOD.register("asparagus", () -> new Item(ModRegistration.itemProps().food(buildFoodValues(1, 0.5F))));
    public static final RegistryObject<Item> asparagus_pieces = FOOD.register("asparagus_pieces", () -> new Item(ModRegistration.itemProps().food(buildFoodValues(1, 0.4F))));
    public static final RegistryObject<Item> carrot_pieces = FOOD.register("carrot_pieces", () -> new Item(ModRegistration.itemProps().food(buildFoodValues(1, 0.6F, new MobEffectInstance(MobEffects.POISON, 150, 1), 30))));
    public static final RegistryObject<Item> chicken_fricassee = FOOD.register("chicken_fricassee", () -> new Item(ModRegistration.itemProps().food(buildFoodValues(11, 0.55F))));
    public static final RegistryObject<Item> chicken_fricassee_raw = FOOD.register("chicken_fricassee_raw", () -> new Item(ModRegistration.itemProps().food(buildFoodValues(4, 0.05F, new MobEffectInstance(MobEffects.POISON, 150, 1), 95))));
    public static final RegistryObject<Item> chicken_fricassee_special = FOOD.register("chicken_fricassee_special", () -> new Item(ModRegistration.itemProps().food(buildFoodValues(12, 0.55F))));
    public static final RegistryObject<Item> chicken_fricassee_special_raw = FOOD.register("chicken_fricassee_special_raw", () -> new Item(ModRegistration.itemProps().food(buildFoodValues(4, 0.05F, new MobEffectInstance(MobEffects.POISON, 120, 1), 95))));
    public static final RegistryObject<Item> chicken_fricassee_rice = FOOD.register("chicken_fricassee_rice", () -> new Item(ModRegistration.itemProps().food(buildFoodValues(13, 0.55F))));
    public static final RegistryObject<Item> chicken_fricassee_rice_raw = FOOD.register("chicken_fricassee_rice_raw", () -> new Item(ModRegistration.itemProps().food(buildFoodValues(5, 0.05F, new MobEffectInstance(MobEffects.POISON, 100, 1), 90))));
    public static final RegistryObject<Item> chicken_pieces = FOOD.register("chicken_pieces", () -> new Item(ModRegistration.itemProps().food(buildFoodValues(1, 0.2F))));
    public static final RegistryObject<Item> dog_goulash = FOOD.register("dog_goulash", () -> new Item(ModRegistration.itemProps().food(buildFoodValues(8, 0.45F, new MobEffectInstance(MobEffects.DAMAGE_BOOST, 150, 1), 30))));
    public static final RegistryObject<Item> dog_goulash_raw = FOOD.register("dog_meat_raw", () -> new Item(ModRegistration.itemProps().food(buildFoodValues(4, 0.2F, new MobEffectInstance(MobEffects.POISON, 150, 1), 30))));
    public static final RegistryObject<Item> horse_meat = FOOD.register("horse_meat", () -> new Item(ModRegistration.itemProps().food(buildFoodValues(4, 0.2F, new MobEffectInstance(MobEffects.POISON, 150, 1), 10))));
    public static final RegistryObject<Item> ice_cream = FOOD.register("ice_cream", () -> new Item(ModRegistration.itemProps().food(buildFoodValues(5, 0.1F, new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 100, 1), 30))));
    public static final RegistryObject<Item> ice_cream_baked = FOOD.register("ice_cream_baked", () -> new Item(ModRegistration.itemProps().food(buildFoodValues(2, 0.1F, new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 150, 1), 40))));
    public static final RegistryObject<Item> lasagne = FOOD.register("lasagne", () -> new Item(ModRegistration.itemProps().food(buildFoodValues(12, 0.5F))));
    public static final RegistryObject<Item> mixed_vegetables = FOOD.register("mixed_vegetables", () -> new Item(ModRegistration.itemProps().food(buildFoodValues(3, 0.8F))));
    public static final RegistryObject<Item> peas = FOOD.register("peas", () -> new Item(ModRegistration.itemProps().food(buildFoodValues(1, 0.5F))));
    public static final RegistryObject<Item> rice = FOOD.register("rice", () -> new Item(ModRegistration.itemProps().food(buildFoodValues(1, 0.5F))));

    // seeds
    public static final RegistryObject<Item> agaricus_seed = SEEDS.register("agaricus_seed", () -> new ModSeed(agaricus_block.get(), ModRegistration.itemProps()));
    public static final RegistryObject<Item> asparagus_seed = SEEDS.register("asparagus_seed", () -> new ModSeed(asparagus_block.get(), ModRegistration.itemProps()));
    public static final RegistryObject<Item> peas_seed = SEEDS.register("peas_seed", () -> new ModSeed(peas_block.get(), ModRegistration.itemProps()));
    public static final RegistryObject<Item> rice_seed = SEEDS.register("rice_seed", () -> new ModSeed(rice_block.get(), ModRegistration.itemProps()));

    private static FoodProperties buildFoodValues(int hunger, float saturation) {
        return new FoodProperties.Builder().nutrition(hunger).saturationMod(saturation).build();
    }

    private static FoodProperties buildFoodValues(int hunger, float saturation, MobEffectInstance effect, int chance) {
        return new FoodProperties.Builder().nutrition(hunger).saturationMod(saturation).effect(() -> effect, chance).build();
    }

    private static Item.Properties itemProps() {
        return new Item.Properties().tab(MoreXFood.creativeTab);
    }
}
