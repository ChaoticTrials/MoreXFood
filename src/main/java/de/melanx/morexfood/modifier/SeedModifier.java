package de.melanx.morexfood.modifier;

import com.google.gson.JsonObject;
import de.melanx.morexfood.config.ConfigHandler;
import de.melanx.morexfood.datagen.handler.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Random;

public class SeedModifier extends LootModifier {

    public SeedModifier(LootItemCondition[] conditions) {
        super(conditions);
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> loot, LootContext context) {
        if (!loot.isEmpty() || !ConfigHandler.seedDrops.get()) {
            return loot;
        }

        if (context.hasParam(LootContextParams.BLOCK_STATE)) {
            BlockState state = context.getParam(LootContextParams.BLOCK_STATE);
            if (state.is(Blocks.GRASS) || state.is(Blocks.TALL_GRASS) || state.is(Blocks.FERN)) {
                if (Math.random() < ConfigHandler.seedDropChance.get()) {
                    loot = List.of(new ItemStack(ModTags.ModItems.SEEDS.getRandomElement(new Random())));
                }
            }
        }

        return loot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<SeedModifier> {

        @Override
        public SeedModifier read(ResourceLocation location, JsonObject json, LootItemCondition[] conditions) {
            return new SeedModifier(conditions);
        }

        @Override
        public JsonObject write(SeedModifier instance) {
            return this.makeConditions(instance.conditions);
        }
    }
}
