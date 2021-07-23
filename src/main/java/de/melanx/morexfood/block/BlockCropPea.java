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

public class BlockCropPea extends BaseCrop {
    private static final IntegerProperty PEAS_AGE = BlockStateProperties.AGE_5;

    public BlockCropPea(Properties properties) {
        super(properties);
    }

    @Nonnull
    @Override
    public IntegerProperty getAgeProperty() {
        return PEAS_AGE;
    }

    @Nonnull
    @Override
    public ItemLike getBaseSeedId() {
        return Registry.peas_seed.get();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(PEAS_AGE);
    }

    @Override
    public Item getDrop() {
        return Registry.peas.get();
    }
}
