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
   public static ItemAsparagus asparagus = new ItemAsparagus();
   public static ItemAsparagusSeed asparagusSeed = new ItemAsparagusSeed();
   public static ItemAgaricus agaricus = new ItemAgaricus();
   public static ItemAgaricusSeed agaricusSeed = new ItemAgaricusSeed();
   public static ItemRice rice = new ItemRice();
   public static ItemRiceSeed riceSeed = new ItemRiceSeed();

   public static void register(IForgeRegistry<Item> registry) {
       registry.registerAll(
               itemKnife,
               peaSeed,
               pea,
               carrotPieces,
               asparagus,
               asparagusSeed,
               agaricus,
               agaricusSeed,
               rice,
               riceSeed
       );
   }
  
   public static void registerModels() {
       itemKnife.registerItemModel();
       peaSeed.registerItemModel();
       pea.registerItemModel();
       carrotPieces.registerItemModel();
       asparagus.registerItemModel();
       asparagusSeed.registerItemModel();
       agaricus.registerItemModel();
       agaricusSeed.registerItemModel();
       rice.registerItemModel();
       riceSeed.registerItemModel();
   }
}