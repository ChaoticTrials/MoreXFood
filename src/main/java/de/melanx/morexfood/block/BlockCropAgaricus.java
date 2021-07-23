package de.melanx.morexfood.block;

import de.melanx.morexfood.util.Registry;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import javax.annotation.Nonnull;

public class BlockCropAgaricus extends BaseCrop {
    private static final IntegerProperty AGARICUS_AGE = BlockStateProperties.AGE_2;

    public BlockCropAgaricus(Properties properties) {
        super(properties);
    }

    @Nonnull
    @Override
    public IntegerProperty getAgeProperty() {
        return AGARICUS_AGE;
    }

    @Nonnull
    @Override
    public ItemLike getBaseSeedId() {
        return Registry.agaricus_seed.get();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGARICUS_AGE);
    }

    @Override
    public Item getDrop() {
        return Registry.agaricus.get();
    }
}
