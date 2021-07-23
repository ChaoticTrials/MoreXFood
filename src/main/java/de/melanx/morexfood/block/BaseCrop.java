package de.melanx.morexfood.block;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;

import java.util.Collections;

public class BaseCrop extends CropBlock {

    public BaseCrop(Properties builder) {
        super(builder);
    }

    public Item getDrop() {
        return null;
    }

    @Override
    public int getMaxAge() {
        return Collections.max(this.getAgeProperty().getPossibleValues());
    }

    public ItemLike getSeed() {
        return this.getBaseSeedId();
    }
}
