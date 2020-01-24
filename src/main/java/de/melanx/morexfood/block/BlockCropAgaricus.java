package de.melanx.morexfood.block;

import de.melanx.morexfood.util.Registry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.IItemProvider;

public class BlockCropAgaricus extends BaseCrop {
    private static final IntegerProperty AGARICUS_AGE = BlockStateProperties.AGE_0_3;

    public BlockCropAgaricus(Properties properties) {
        super(properties);
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGARICUS_AGE;
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    public IItemProvider getSeedsItem() {
        return Registry.agaricus_seed.get();
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(AGARICUS_AGE);
    }

    @Override
    public Item getDrop() {
        return Registry.agaricus.get();
    }
}