package de.melanx.morexfood.items;

import de.melanx.morexfood.util.IModSeed;
import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;

public class ModSeed extends BlockNamedItem implements IModSeed {

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
