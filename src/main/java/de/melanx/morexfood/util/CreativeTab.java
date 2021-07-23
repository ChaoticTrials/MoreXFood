package de.melanx.morexfood.util;

import de.melanx.morexfood.MoreXFood;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

public class CreativeTab extends CreativeModeTab {

    public CreativeTab() {
        super(MoreXFood.MODID);
    }

    @Nonnull
    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ModRegistration.chicken_fricassee_special.get());
    }
}
