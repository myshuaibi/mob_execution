package com.myshuaibi.mobexecution.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import com.myshuaibi.mobexecution.init.MobExecutionModItems;

public class UpgradeGetProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z, String tem) {
		if (tem == null)
			return 0;
		double i = 0;
		double result = 0;
		i = 2;
		for (int index0 = 0; index0 < 7; index0++) {
			i++;
			if (ExpansionDetectionItemProcedure.execute(world, x, y - 1, z) >= i - 6) {
				if ((tem).equals("create")) {
					if ((itemFromBlockInventory(world, BlockPos.containing(x, y - 1, z), (int) i).copy()).getItem() == MobExecutionModItems.CREATE_UPGRADE.get()) {
						result++;
					}
				}
				if ((tem).equals("easter_egg")) {
					if ((itemFromBlockInventory(world, BlockPos.containing(x, y - 1, z), (int) i).copy()).getItem() == MobExecutionModItems.EASTER_EGG_UPGRADE.get()) {
						result++;
					}
				}
				if ((tem).equals("efficiency")) {
					if ((itemFromBlockInventory(world, BlockPos.containing(x, y - 1, z), (int) i).copy()).getItem() == MobExecutionModItems.EFFICIENCY_UPGRADE.get()) {
						result = result + 2;
					}
					if ((itemFromBlockInventory(world, BlockPos.containing(x, y - 1, z), (int) i).copy()).getItem() == MobExecutionModItems.EFFICIENCY_UPGRADE_HIGH.get()) {
						result = result + 4;
					}
				}
				if ((tem).equals("real_damage")) {
					if ((itemFromBlockInventory(world, BlockPos.containing(x, y - 1, z), (int) i).copy()).getItem() == MobExecutionModItems.REAL_DAMAGE_UPGRADE.get()) {
						result++;
					}
				}
				if ((tem).equals("regeneration")) {
					if ((itemFromBlockInventory(world, BlockPos.containing(x, y - 1, z), (int) i).copy()).getItem() == MobExecutionModItems.REGENERATION_UPGRADE.get()) {
						result++;
					}
				}
				if ((tem).equals("simulate")) {
					if ((itemFromBlockInventory(world, BlockPos.containing(x, y - 1, z), (int) i).copy()).getItem() == MobExecutionModItems.SIMULATE_UPGRADE.get()) {
						result++;
					}
				}
				if ((tem).equals("transmission")) {
					if ((itemFromBlockInventory(world, BlockPos.containing(x, y - 1, z), (int) i).copy()).getItem() == MobExecutionModItems.TRANSMISSION_UPGRADE.get()) {
						result++;
					}
				}
			}
		}
		return result;
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
}