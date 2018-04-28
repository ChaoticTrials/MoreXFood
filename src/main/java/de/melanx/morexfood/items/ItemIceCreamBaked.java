package de.melanx.morexfood.items;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.oredict.OreDictionary;

public class ItemIceCreamBaked extends ItemFood {

    final Potion potion = Potion.getPotionFromResourceLocation("speed");

    public ItemIceCreamBaked() {
        super(2, 0.1f, false);
        setUnlocalizedName("baked_ice_cream");
        setRegistryName("baked_ice_cream");
        setCreativeTab(morexfood.creativeTab);
        setPotionEffect(new PotionEffect(potion, 100, 0), 30);
    }

    public void registerItemModel() {
        morexfood.proxy.registerItemRenderer(this, 0, "ice_cream_baked");
    }

    public void initOreDict() {
        OreDictionary.registerOre("iceCream", this);
        OreDictionary.registerOre("iceCreamBaked", this);
    }

}