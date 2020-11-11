package de.melanx.morexfood.util;

import de.melanx.morexfood.MoreXFood;
import de.melanx.morexfood.config.ConfigHandler;
import de.melanx.morexfood.datagen.handler.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.play.server.SChangeBlockPacket;
import net.minecraft.state.IntegerProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.system.CallbackI;

import java.util.Collections;
import java.util.Random;

@Mod.EventBusSubscriber(modid = MoreXFood.MODID)
public class Events {

    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        LivingEntity deadEntity = event.getEntityLiving();
        World world = deadEntity.getEntityWorld();
        BlockPos position = deadEntity.getPosition();
        double x = position.getX();
        double y = position.getY();
        double z = position.getZ();
        if (deadEntity instanceof HorseEntity) {
            if (world.rand.nextDouble() <= 0.6D) {
                int i = world.rand.nextInt(2);
                for (int j = 0; j <= i; j++)
                    event.getDrops().add(new ItemEntity(world, x, y, z, new ItemStack(Registry.horse_meat.get())));
            }
        }
        if (deadEntity instanceof WolfEntity) {
            if (world.rand.nextDouble() <= 0.4D) {
                event.getDrops().add(new ItemEntity(world, x, y, z, new ItemStack(Registry.dog_goulash_raw.get())));
            }
        }
    }

    @SubscribeEvent
    public static void onGrassBroken(BlockEvent.BreakEvent event) {
        Block block = event.getState().getBlock();
        IWorld world = event.getWorld();
        PlayerEntity player = event.getPlayer();
        BlockPos pos = event.getPos();

        if (!world.isRemote()) {
            if (ConfigHandler.seedDrops.get())
                if (player.getHeldItemMainhand().getItem() != Items.SHEARS || !player.isCreative()) {
                    if (block == Blocks.GRASS || block == Blocks.TALL_GRASS || block == Blocks.FERN) {
                        Item seed = ModTags.SEEDS.getRandomElement(new Random());
                        if (Math.random() <= (double) ConfigHandler.seedDropChance.get() / 100) {
                            dropItem(world, pos, seed);
                        }
                    }
                }
        }
    }
    
    @SubscribeEvent
    public static void activateBlock(PlayerInteractEvent.RightClickBlock event) {
        World world = event.getWorld();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);
        PlayerEntity player = event.getPlayer();
        ItemStack stack = event.getItemStack();
        if (!world.isRemote) {
            if (state.getBlock() instanceof CropsBlock) {
                IntegerProperty property = ((CropsBlock) state.getBlock()).getAgeProperty();
                if (state.get(property) >= Collections.max(property.getAllowedValues())) {
                    state.getBlock().harvestBlock(world, player, pos, state, null, stack);

                    Block.getDrops(state, (ServerWorld) world, pos, null, player, stack).forEach(stackToSpawn -> {
                        if (stackToSpawn.getItem() == state.getBlock().asItem()) {
                            stackToSpawn.shrink(1);
                        }
                        Block.spawnAsEntity(world, pos, stackToSpawn);
                        state.spawnAdditionalDrops((ServerWorld) world, pos, stack);
                    });

                    world.setBlockState(pos, state.with(property, 0));
                    ((ServerPlayerEntity) player).connection.sendPacket(new SChangeBlockPacket(world, pos));
                }
            }
        }
    }

    private static void dropItem(IWorld world, BlockPos pos, Item item) {
        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
        world.addEntity(new ItemEntity((World) world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(item)));
    }
}
