package de.melanx.morexfood.items;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemLasagne extends ItemFood {

    final Potion potion = Potion.getPotionFromResourceLocation("nausea");

    public ItemLasagne() {
        super(12, 0.5f, false);
        setUnlocalizedName("lasagne");
        setRegistryName("lasagne");
        setCreativeTab(morexfood.creativeTab);
        setPotionEffect(new PotionEffect(potion, 600, 0), 40);
    }

    public void registerItemModel() {
        morexfood.proxy.registerItemRenderer(this, 0, "lasagne");
    }

}
