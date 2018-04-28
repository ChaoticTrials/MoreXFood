package de.melanx.morexfood.items;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.oredict.OreDictionary;

public class ItemIceCream extends ItemFood {

    final Potion potion = Potion.getPotionFromResourceLocation("fire_resistance");

    public ItemIceCream() {
        super(5, 0.1f, false);
        setUnlocalizedName("ice_cream");
        setRegistryName("ice_cream");
        setCreativeTab(morexfood.creativeTab);
        setPotionEffect(new PotionEffect(potion, 100, 0), 30);
    }

    public void registerItemModel() {
        morexfood.proxy.registerItemRenderer(this, 0, "ice_cream");
    }

    public void initOreDict() {
        OreDictionary.registerOre("iceCream", this);
    }

}