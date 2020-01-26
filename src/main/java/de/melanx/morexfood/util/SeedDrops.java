package de.melanx.morexfood.util;

import de.melanx.morexfood.datagen.handler.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Random;

public class SeedDrops {

    @SubscribeEvent
    public void onGrassBroken(BlockEvent.BreakEvent event) {
        Block block = event.getState().getBlock();
        IWorld world = event.getWorld();
        PlayerEntity player = event.getPlayer();
        BlockPos pos = event.getPos();

        if (!world.isRemote()) {
            // TODO config to disable seed drops
            if (player.getHeldItemMainhand().getItem() != Items.SHEARS || !player.isCreative()) {
                if (block == Blocks.GRASS || block == Blocks.TALL_GRASS || block == Blocks.FERN) {
                    Item seed = ModTags.SEEDS.getRandomElement(new Random());
                    // TODO config
                    if (Math.random() <= (double) 5 / 100) {
                        this.dropItem(world, pos, seed);
                    }
                }
            }
        }
    }

    private void dropItem(IWorld world, BlockPos pos, Item item) {
        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
        world.addEntity(new ItemEntity((World) world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(item)));
    }

}