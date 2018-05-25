package de.melanx.morexfood.items;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.oredict.OreDictionary;

public class ItemDogGoulash extends ItemFood {

    final Potion potion = Potion.getPotionFromResourceLocation("strength");

    public ItemDogGoulash() {
        super(8, 0.45f, false);
        setUnlocalizedName("dog_goulash");
        setRegistryName("dog_goulash");
        setCreativeTab(morexfood.creativeTab);
        setPotionEffect(new PotionEffect(potion, 150, 0), 30);
    }

    public void registerItemModel() {
        morexfood.proxy.registerItemRenderer(this, 0, "dog_goulash");
    }

    public void initOreDict() {
        OreDictionary.registerOre("dogGoulash", this);
    }

}
