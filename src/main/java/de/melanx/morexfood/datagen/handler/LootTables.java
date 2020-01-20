package de.melanx.morexfood.datagen.handler;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import de.melanx.morexfood.util.Registry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.*;
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
                // TODO correct items
                registerDropping(block, Blocks.DIRT);
            }
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return Registry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
        }
    }

}
