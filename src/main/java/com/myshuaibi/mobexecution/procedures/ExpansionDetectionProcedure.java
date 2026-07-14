package com.myshuaibi.mobexecution.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import com.myshuaibi.mobexecution.init.MobExecutionModMenus;
import com.myshuaibi.mobexecution.init.MobExecutionModItems;

public class ExpansionDetectionProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double result = 0;
		boolean nether = false;
		boolean end = false;
		boolean overworld = false;
		Entity target_entity = null;
		for (int index0 = 0; index0 < 3; index0++) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MobExecutionModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get((int) index0).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("mob_execution:expansion_template")))) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MobExecutionModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get((int) index0).getItem() : ItemStack.EMPTY)
						.getItem() == MobExecutionModItems.OVERWORLD_EXPANSION_TEMPLATE.get()) {
					overworld = true;
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MobExecutionModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get((int) index0).getItem() : ItemStack.EMPTY)
						.getItem() == MobExecutionModItems.NETHER_EXPANSION_TEMPLATE.get()) {
					nether = true;
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MobExecutionModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get((int) index0).getItem() : ItemStack.EMPTY)
						.getItem() == MobExecutionModItems.END_EXPANSION_TEMPLATE.get()) {
					end = true;
				}
			}
		}
		if (overworld) {
			result += 1;
		}
		if (nether) {
			result += 1;
		}
		if (end) {
			result += 1;
		}
		return result;
	}
}