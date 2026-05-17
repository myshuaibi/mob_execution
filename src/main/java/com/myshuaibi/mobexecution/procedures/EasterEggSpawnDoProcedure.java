package com.myshuaibi.mobexecution.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;

import com.myshuaibi.mobexecution.init.MobExecutionModItems;

public class EasterEggSpawnDoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double num) {
		ItemStack item = ItemStack.EMPTY;
		item = new ItemStack(MobExecutionModItems.EASTER_EGG_UPGRADE.get()).copy();
		item.setCount((int) num);
		if (world instanceof ServerLevel _level) {
			ItemEntity entityToSpawn = new ItemEntity(_level, x, (y + 0.5), z, item);
			entityToSpawn.setPickUpDelay(0);
			entityToSpawn.setUnlimitedLifetime();
			_level.addFreshEntity(entityToSpawn);
		}
	}
}