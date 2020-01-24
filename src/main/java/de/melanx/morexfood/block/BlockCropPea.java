package de.melanx.morexfood.block;

import de.melanx.morexfood.util.Registry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.IItemProvider;

public class BlockCropPea extends BaseCrop {
    private static final IntegerProperty PEAS_AGE = BlockStateProperties.AGE_0_5;

    public BlockCropPea(Properties properties) {
        super(properties);
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return PEAS_AGE;
    }

    @Override
    public int getMaxAge() {
        return 5;
    }

    @Override
    public IItemProvider getSeedsItem() {
        return Registry.peas_seed.get();
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(PEAS_AGE);
    }

    @Override
    public Item getDrop() {
        return Registry.peas.get();
    }
}