package de.melanx.morexfood.util;

import de.melanx.morexfood.MoreXFood;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CreativeTab extends ItemGroup {

    public CreativeTab() {
        super(MoreXFood.MODID);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Registry.chicken_fricassee_special.get());
    }
}
