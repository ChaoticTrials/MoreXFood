package de.melanx.morexfood.util;

import de.melanx.morexfood.MoreXFood;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundBlockUpdatePacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collections;

@Mod.EventBusSubscriber(modid = MoreXFood.MODID)
public class Events {

    @SubscribeEvent
    public static void activateBlock(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getWorld();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);
        Player player = event.getPlayer();
        ItemStack stack = event.getItemStack();
        if (!level.isClientSide) {
            if (state.getBlock() instanceof CropBlock) {
                IntegerProperty property = ((CropBlock) state.getBlock()).getAgeProperty();
                if (state.getValue(property) >= Collections.max(property.getPossibleValues())) {
                    state.getBlock().playerDestroy(level, player, pos, state, null, stack);

                    Block.getDrops(state, (ServerLevel) level, pos, null, player, stack).forEach(stackToSpawn -> {
                        if (stackToSpawn.getItem() == state.getBlock().asItem()) {
                            stackToSpawn.shrink(1);
                        }
                        Block.popResource(level, pos, stackToSpawn);
                        state.spawnAfterBreak((ServerLevel) level, pos, stack);
                    });

                    level.setBlockAndUpdate(pos, state.setValue(property, 0));
                    ((ServerPlayer) player).connection.send(new ClientboundBlockUpdatePacket(level, pos));
                }
            }
        }
    }
}
