package de.melanx.morexfood.modifier;

import com.google.gson.JsonObject;
import de.melanx.morexfood.util.ModRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Random;

public class HorseDrops extends LootModifier {

    public HorseDrops(LootItemCondition[] conditions) {
        super(conditions);
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> loot, LootContext context) {
        if (context.hasParam(LootContextParams.THIS_ENTITY)) {
            Entity dead = context.getParam(LootContextParams.THIS_ENTITY);
            if (dead instanceof AbstractHorse && Math.random() < 0.6) {
                Random random = context.getRandom();
                int i = random.nextInt(2 + context.getLootingModifier()) + 1;
                loot.add(new ItemStack(ModRegistration.horse_meat.get(), i));
            }
        }

        return loot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<HorseDrops> {

        @Override
        public HorseDrops read(ResourceLocation location, JsonObject json, LootItemCondition[] conditions) {
            return new HorseDrops(conditions);
        }

        @Override
        public JsonObject write(HorseDrops instance) {
            return this.makeConditions(instance.conditions);
        }
    }
}
