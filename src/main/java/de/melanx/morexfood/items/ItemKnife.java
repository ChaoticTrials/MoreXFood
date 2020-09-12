package de.melanx.morexfood.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemKnife extends Item {
    public ItemKnife(Item.Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        return new ItemStack(this);
    }
}
