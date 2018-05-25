package de.melanx.morexfood.items;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.oredict.OreDictionary;

public class ItemHorseMeat extends ItemFood {

    final Potion potion = Potion.getPotionFromResourceLocation("poison");

    public ItemHorseMeat() {
        super(4, 0.2f, false);
        setUnlocalizedName("horse_meat");
        setRegistryName("horse_meat");
        setCreativeTab(morexfood.creativeTab);
        setPotionEffect(new PotionEffect(potion, 150, 0), 10);
    }

    public void registerItemModel() {
        morexfood.proxy.registerItemRenderer(this, 0, "horse_meat");
    }

    public void initOreDict() {
        OreDictionary.registerOre("meatHorse", this);
    }

}
