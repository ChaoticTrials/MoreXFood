package de.melanx.morexfood.block;

import net.minecraft.block.CropsBlock;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;

public class BaseCrop extends CropsBlock {

    public BaseCrop(Properties builder) {
        super(builder);
    }

    public Item getDrop() {
        return null;
    }

    public IItemProvider getSeed() {
        return this.getSeedsItem();
    }
}
