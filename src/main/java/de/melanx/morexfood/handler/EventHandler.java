package de.melanx.morexfood.handler;

import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {
	
    @SubscribeEvent
    public void harvestEvent(HarvestDropsEvent event) {
        
    	super(world, pos, state);
        this.setDropChance = 10;
        this.drops = new ItemStack(ItemPeaSeed);
        this.harvester = harvester;
    }

}