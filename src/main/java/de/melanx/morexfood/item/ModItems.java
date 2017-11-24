package de.melanx.morexfood.item;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import de.melanx.morexfood.item.ItemPeaSeed;

public class ModItems {

   // public static ItemBase name = new ItemBase("name");
   public static ItemBase itemKnife = new ItemBase("knife");
   public static ItemPeaSeed peaSeed = new ItemPeaSeed();
   public static ItemPea pea = new ItemPea();
   public static ItemCarrotPieces carrotPieces = new ItemCarrotPieces();

   public static void register(IForgeRegistry<Item> registry) {
       registry.registerAll(
               itemKnife,
               peaSeed,
               pea,
               carrotPieces
       );
   }
  
   public static void registerModels() {
       itemKnife.registerItemModel();
       peaSeed.registerItemModel();
       pea.registerItemModel();
       carrotPieces.registerItemModel();
   }
}