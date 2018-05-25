package de.melanx.morexfood.items;

import de.melanx.morexfood.morexfood;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.oredict.OreDictionary;

public class ItemRawDogGoulash extends ItemFood {

    final Potion potion = Potion.getPotionFromResourceLocation("poison");

    public ItemRawDogGoulash() {
        super(4, 0.2f, false);
        setUnlocalizedName("raw_dog_meat");
        setRegistryName("raw_dog_meat");
        setCreativeTab(morexfood.creativeTab);
        setPotionEffect(new PotionEffect(potion, 150, 0), 30);
    }

    public void registerItemModel() {
        morexfood.proxy.registerItemRenderer(this, 0, "raw_dog_meat");
    }

    public void initOreDict() {
        OreDictionary.registerOre("goulashDog", this);
    }

}
