package de.melanx.morexfood.block;

import de.melanx.morexfood.util.Registry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.IItemProvider;

public class BlockCropRice extends BaseCrop {
    private static final IntegerProperty RICE_AGE = BlockStateProperties.AGE_0_3;

    public BlockCropRice(Properties properties) {
        super(properties);
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return RICE_AGE;
    }

    @Override
    public IItemProvider getSeedsItem() {
        return Registry.rice_seed.get();
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(RICE_AGE);
    }

    @Override
    public Item getDrop() {
        return Registry.rice.get();
    }
}