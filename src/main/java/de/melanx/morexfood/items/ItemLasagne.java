package de.melanx.morexfood.items;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;

public class ItemLasagne extends ItemFood {

    public ItemLasagne() {
        super(6, 0.5f, false);
        setUnlocalizedName("lasagne");
        setRegistryName("lasagne");
        setCreativeTab(morexfood.creativeTab);
    }

    public void registerItemModel() {
        morexfood.proxy.registerItemRenderer(this, 0, "lasagne");
    }

}
