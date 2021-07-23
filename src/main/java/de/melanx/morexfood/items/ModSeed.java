package de.melanx.morexfood.items;

import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;

public class ModSeed extends ItemNameBlockItem {

    Block crop;

    public ModSeed(Block crop, Properties properties) {
        super(crop, properties);
        this.crop = crop;
    }

    public Block getCrop() {
        return this.crop;
    }
}
