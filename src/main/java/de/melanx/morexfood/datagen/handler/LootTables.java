package de.melanx.morexfood.datagen.handler;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import de.melanx.morexfood.block.BaseCrop;
import de.melanx.morexfood.util.Registry;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.BlockStateProperty;
import net.minecraft.world.storage.loot.conditions.ILootCondition;
import net.minecraft.world.storage.loot.functions.ApplyBonus;
import net.minecraft.world.storage.loot.functions.SetCount;
import net.minecraftforge.fml.RegistryObject;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LootTables extends LootTableProvider {

    public LootTables(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return ImmutableList.of(
                Pair.of(BlockTable::new, LootParameterSets.BLOCK)
        );
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationResults validationresults) {
        map.forEach((name, table) -> LootTableManager.func_215302_a(validationresults, name, table, map::get));
    }

    private class BlockTable extends BlockLootTables {
        @Override
        protected void addTables() {
            for (RegistryObject<Block> blockRegistry : Registry.BLOCKS.getEntries()) {
                Block block = blockRegistry.get();
                if (block instanceof BaseCrop) {
                    IntegerProperty property = BlockStateProperties.AGE_0_3;
                    if (((BaseCrop) block).getAgeProperty() != property)
                        property = ((BaseCrop) block).getAgeProperty();
                    ILootCondition.IBuilder builder = BlockStateProperty.builder(block).with(property, ((BaseCrop) block).getMaxAge());
                    registerLootTable(block, (drop) -> {
                        BaseCrop crop = (BaseCrop) block;
                        return droppingAndBonusWhen(drop, crop.getDrop(), crop.getSeed().asItem(), builder);
                    });
                } else {
                    registerLootTable(block, (drop) -> droppingWithSilkTouch(drop, withExplosionDecay(drop, ItemLootEntry.builder(Registry.dust_salt.get()).acceptFunction(SetCount.builder(RandomValueRange.of(4.0F, 5.0F))).acceptFunction(ApplyBonus.uniformBonusCount(Enchantments.FORTUNE)))));
                }
            }
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return Registry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
        }
    }

}
