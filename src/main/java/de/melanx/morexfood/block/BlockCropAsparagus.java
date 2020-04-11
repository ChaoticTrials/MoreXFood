package de.melanx.morexfood.block;

import de.melanx.morexfood.util.Registry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.IItemProvider;

public class BlockCropAsparagus extends BaseCrop {
    private static final IntegerProperty ASPARAGUS_AGE = BlockStateProperties.AGE_0_2;

    public BlockCropAsparagus(Properties properties) {
        super(properties);
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return ASPARAGUS_AGE;
    }

    @Override
    public IItemProvider getSeedsItem() {
        return Registry.asparagus_seed.get();
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(ASPARAGUS_AGE);
    }

    @Override
    public Item getDrop() {
        return Registry.asparagus.get();
    }
}