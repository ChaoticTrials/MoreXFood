package de.melanx.morexfood.util;

import de.melanx.morexfood.MoreXFood;
import de.melanx.morexfood.config.ConfigHandler;
import de.melanx.morexfood.datagen.handler.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundBlockUpdatePacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collections;
import java.util.Random;

@Mod.EventBusSubscriber(modid = MoreXFood.MODID)
public class Events {

    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        LivingEntity deadEntity = event.getEntityLiving();
        Level level = deadEntity.getCommandSenderWorld();
        BlockPos position = deadEntity.blockPosition();
        double x = position.getX();
        double y = position.getY();
        double z = position.getZ();
        if (deadEntity instanceof Horse) {
            if (level.random.nextDouble() <= 0.6D) {
                int i = level.random.nextInt(2);
                for (int j = 0; j <= i; j++)
                    event.getDrops().add(new ItemEntity(level, x, y, z, new ItemStack(ModRegistration.horse_meat.get())));
            }
        }
        if (deadEntity instanceof Wolf) {
            if (level.random.nextDouble() <= 0.4D) {
                event.getDrops().add(new ItemEntity(level, x, y, z, new ItemStack(ModRegistration.dog_goulash_raw.get())));
            }
        }
    }

    @SubscribeEvent
    public static void onGrassBroken(BlockEvent.BreakEvent event) {
        Block block = event.getState().getBlock();
        LevelAccessor level = event.getWorld();
        Player player = event.getPlayer();
        BlockPos pos = event.getPos();

        if (!level.isClientSide()) {
            if (ConfigHandler.seedDrops.get())
                if (player.getMainHandItem().getItem() != Items.SHEARS || !player.isCreative()) {
                    if (block == Blocks.GRASS || block == Blocks.TALL_GRASS || block == Blocks.FERN) {
                        Item seed = ModTags.ModItems.SEEDS.getRandomElement(new Random());
                        if (Math.random() <= (double) ConfigHandler.seedDropChance.get() / 100) {
                            dropItem(level, pos, seed);
                        }
                    }
                }
        }
    }
    
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

    private static void dropItem(LevelAccessor level, BlockPos pos, Item item) {
        level.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
        level.addFreshEntity(new ItemEntity((Level) level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(item)));
    }
}
