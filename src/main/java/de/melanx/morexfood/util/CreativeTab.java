package de.melanx.morexfood.util;

import de.melanx.morexfood.MoreXFood;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeTab extends CreativeModeTab {

    public CreativeTab() {
        super(MoreXFood.MODID);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(Registry.chicken_fricassee_special.get());
    }
}
