package com.myshuaibi.mobexecution.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import com.myshuaibi.mobexecution.init.MobExecutionModItems;

@EventBusSubscriber
public class ExecutionUseProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState target_block = Blocks.AIR.defaultBlockState();
		Entity lord = null;
		double health = 0;
		target_block = (world.getBlockState(BlockPos.containing(x, y - 1, z)));
		if (PoweredJudgmentProcedure.execute(target_block)) {
			if (entity instanceof LivingEntity) {
				if (EntityConditionCheckProcedure.execute(world, x, y, z, entity)) {
					ExecutionDamageProcedure.execute(world, x, y, z, entity);
				}
			} else if (UpgradeGetProcedure.execute(world, x, y, z, new ItemStack(MobExecutionModItems.TRANSMISSION_UPGRADE.get())) > 0 && (entity instanceof ItemEntity || entity instanceof ExperienceOrb)) {
				if (!world.isClientSide()) {
					lord = GetLordFromUuidProcedure.execute(getBlockNBTString(world, BlockPos.containing(x, y - 1, z), "lord"));
					if (lord != null) {
						ServerLevel lordLevel = (ServerLevel) lord.level();
						if (lordLevel != null) {
							entity.teleportTo(lordLevel, lord.getX(), lord.getY(), lord.getZ(), java.util.Set.of(), entity.getYRot(), entity.getXRot());
						}
					}
				}
			}
		}
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}
}