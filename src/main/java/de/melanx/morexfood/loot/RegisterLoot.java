package de.melanx.morexfood.loot;

import de.melanx.morexfood.items.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegisterLoot {

    @SubscribeEvent
    public void onLivingDrops(LivingDropsEvent event) {
        EntityLivingBase deadEntity = event.getEntityLiving();
        World world = deadEntity.getEntityWorld();
        BlockPos position = deadEntity.getPosition();
        double x = position.getX();
        double y = position.getY();
        double z = position.getZ();
        if (deadEntity instanceof EntityHorse) {
            if (world.rand.nextInt(2) == 1) {
                event.getDrops().add(new EntityItem(world, x, y, z, new ItemStack(ModItems.horseMeat)));
            } else if (world.rand.nextInt(5) == 3) {
                event.getDrops().add(new EntityItem(world, x, y, z, new ItemStack(ModItems.horseMeat)));
                event.getDrops().add(new EntityItem(world, x, y, z, new ItemStack(ModItems.horseMeat)));
            }
        }
        if (deadEntity instanceof EntityWolf) {
            if (world.rand.nextInt(3) == 1) {
                event.getDrops().add(new EntityItem(world, x, y, z, new ItemStack(ModItems.rawDogGoulash)));
            }
        }
    }

}
