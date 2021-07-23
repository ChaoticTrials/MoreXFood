package de.melanx.morexfood.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ContainerItem extends Item {

    public ContainerItem(Item.Properties properties) {
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
