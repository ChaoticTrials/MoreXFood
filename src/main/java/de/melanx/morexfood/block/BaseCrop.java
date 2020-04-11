package de.melanx.morexfood.block;

import net.minecraft.block.CropsBlock;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;

import java.util.Collections;

public class BaseCrop extends CropsBlock {

    public BaseCrop(Properties builder) {
        super(builder);
    }

    public Item getDrop() {
        return null;
    }

    @Override
    public int getMaxAge() {
        return Collections.max(this.getAgeProperty().getAllowedValues());
    }

    public IItemProvider getSeed() {
        return this.getSeedsItem();
    }
}
