package de.melanx.morexfood.datagen.handler;

import de.melanx.morexfood.MoreXFood;
import de.melanx.morexfood.modifier.HorseDrops;
import de.melanx.morexfood.modifier.SeedModifier;
import de.melanx.morexfood.modifier.WolfDrops;
import de.melanx.morexfood.util.ModRegistration;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class LootModifiers extends GlobalLootModifierProvider {
    public LootModifiers(DataGenerator generator) {
        super(generator, MoreXFood.MODID);
    }

    @Override
    protected void start() {
        this.add("seeds", ModRegistration.seed_modifier.get(), new SeedModifier(new LootItemCondition[]{
                MatchTool.toolMatches(ItemPredicate.Builder.item().of(Tags.Items.SHEARS)).invert().build()
        }));
        this.add("horse", ModRegistration.horse_modifier.get(), new HorseDrops(new LootItemCondition[]{}));
        this.add("wolf", ModRegistration.wolf_modifier.get(), new WolfDrops(new LootItemCondition[]{}));
    }
}
