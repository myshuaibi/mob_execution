package com.myshuaibi.mobexecution.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import com.myshuaibi.mobexecution.init.MobExecutionModItems;

public class ExpansionDetectionItemProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		double result = 0;
		double i = 0;
		boolean nether = false;
		boolean end = false;
		boolean overworld = false;
		for (int index0 = 0; index0 < 3; index0++) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) i).copy()).is(ItemTags.create(ResourceLocation.parse("mob_execution:expansion_template")))) {
				if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) i).copy()).getItem() == MobExecutionModItems.OVERWORLD_EXPANSION_TEMPLATE.get()) {
					overworld = true;
				} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) i).copy()).getItem() == MobExecutionModItems.NETHER_EXPANSION_TEMPLATE.get()) {
					nether = true;
				} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) i).copy()).getItem() == MobExecutionModItems.END_EXPANSION_TEMPLATE.get()) {
					end = true;
				}
			}
			i++;
		}
		if (overworld) {
			result = result + 1;
		}
		if (nether) {
			result = result + 1;
		}
		if (end) {
			result = result + 1;
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