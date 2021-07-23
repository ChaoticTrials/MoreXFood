package de.melanx.morexfood.items;

import de.melanx.morexfood.util.IModSeed;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;

public class ModSeed extends ItemNameBlockItem implements IModSeed {

    Item crop;
    Block cropBlock;

    public ModSeed(Block block, Item crop, Block cropBlock, Properties properties) {
        super(block, properties);
        this.crop = crop;
        this.cropBlock = cropBlock;
    }

    @Override
    public Item getCrop() {
        return this.crop;
    }

    @Override
    public Block getCropBlock() {
        return this.cropBlock;
    }
}
