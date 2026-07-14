package com.myshuaibi.mobexecution.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import com.myshuaibi.mobexecution.init.MobExecutionModItems;

public class UpgradeGetProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		double result = 0;
		double get = 0;
		double add = 0;
		ItemStack item = ItemStack.EMPTY;
		ItemStack blockItem = ItemStack.EMPTY;
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("mob_execution:has_level")))) {
			get = 3;
		} else {
			get = 2;
		}
		for (int index0 = 0; index0 < (int) get; index0++) {
			if (index0 == 0) {
				item = itemstack.copy();
			}
			if (index0 == 1) {
				item = new ItemStack(MobExecutionModItems.INFINITE_UPGRADE.get()).copy();
			}
			if (index0 == 2) {
				if (itemstack.getItem() == MobExecutionModItems.EFFICIENCY_UPGRADE.get()) {
					item = new ItemStack(MobExecutionModItems.EFFICIENCY_UPGRADE_HIGH.get()).copy();
				}
				if (itemstack.getItem() == MobExecutionModItems.LOOTING_UPGRADE.get()) {
					item = new ItemStack(MobExecutionModItems.LOOTING_UPGRADE_HIGH.get()).copy();
				}
			}
			for (int index1 = 0; index1 < 7; index1++) {
				blockItem = (itemFromBlockInventory(world, BlockPos.containing(x, y - 1, z), (int) (index1 + 3)).copy()).copy();
				if (ExpansionDetectionItemProcedure.execute(world, x, y - 1, z) >= (index1 + 3) - 6) {
					if (blockItem.getItem() == item.getItem()) {
						if (item.getItem() == MobExecutionModItems.INFINITE_UPGRADE.get() && itemstack.is(ItemTags.create(ResourceLocation.parse("mob_execution:bypasses_infinite")))) {
							continue;
						}
						add = 1;
						if (item.getItem() == MobExecutionModItems.EFFICIENCY_UPGRADE.get()) {
							add = 2;
						}
						if (item.getItem() == MobExecutionModItems.EFFICIENCY_UPGRADE_HIGH.get()) {
							add = 4;
						}
						if (item.getItem() == MobExecutionModItems.LOOTING_UPGRADE_HIGH.get()) {
							add = 2;
						}
						if (item.getItem() == MobExecutionModItems.INFINITE_UPGRADE.get()) {
							if (blockItem.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("upgrade") > 0) {
								add = blockItem.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("upgrade");
							} else {
								add = 1;
							}
						}
						result += add;
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