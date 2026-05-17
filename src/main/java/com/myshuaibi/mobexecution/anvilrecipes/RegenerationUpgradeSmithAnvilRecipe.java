package com.myshuaibi.mobexecution.anvilrecipes;

import net.neoforged.neoforge.event.AnvilUpdateEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

import com.myshuaibi.mobexecution.init.MobExecutionModItems;

@EventBusSubscriber
public class RegenerationUpgradeSmithAnvilRecipe {
	@SubscribeEvent
	public static void execute(AnvilUpdateEvent event) {
		if ((event.getLeft().getItem() == MobExecutionModItems.EMPTY_UPGRADE_TEMPLATE.get()) && (event.getRight().getItem() == Items.TOTEM_OF_UNDYING)) {
			if ((event.getLeft().getCount() == 1) && (event.getRight().getCount() >= 1)) {
				event.setMaterialCost(1);
				event.setCost(9);
				event.setOutput(new ItemStack(MobExecutionModItems.REGENERATION_UPGRADE.get()));
			}
		}
	}
}