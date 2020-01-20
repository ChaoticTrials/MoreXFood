package de.melanx.morexfood.datagen;

import de.melanx.morexfood.MoreXFood;
import de.melanx.morexfood.datagen.handler.BlockStates;
import de.melanx.morexfood.datagen.handler.ItemModels;
import de.melanx.morexfood.datagen.handler.LootTables;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = MoreXFood.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataCreator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        if (event.includeServer()) {
            gen.addProvider(new LootTables(gen));
        }
        if (event.includeClient()) {
            gen.addProvider(new ItemModels(gen, helper));
            gen.addProvider(new BlockStates(gen, helper));
        }
    }

}
