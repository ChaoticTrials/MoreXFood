package de.melanx.morexfood.block;

import de.melanx.morexfood.util.ModRegistration;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import javax.annotation.Nonnull;

public class BlockCropAsparagus extends BaseCrop {
    private static final IntegerProperty ASPARAGUS_AGE = BlockStateProperties.AGE_2;

    public BlockCropAsparagus(Properties properties) {
        super(properties);
    }

    @Nonnull
    @Override
    public IntegerProperty getAgeProperty() {
        return ASPARAGUS_AGE;
    }

    @Nonnull
    @Override
    public ItemLike getBaseSeedId() {
        return ModRegistration.asparagus_seed.get();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ASPARAGUS_AGE);
    }

    @Override
    public Item getDrop() {
        return ModRegistration.asparagus.get();
    }
}
