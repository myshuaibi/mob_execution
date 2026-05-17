package com.myshuaibi.mobexecution.anvilrecipes;

import net.neoforged.neoforge.event.AnvilUpdateEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;

import com.myshuaibi.mobexecution.init.MobExecutionModBlocks;

@EventBusSubscriber
public class AutoExecutionMachineSmithAnvilRecipe {
	@SubscribeEvent
	public static void execute(AnvilUpdateEvent event) {
		if ((event.getLeft().getItem() == MobExecutionModBlocks.EXECUTION_MACHINE.get().asItem()) && (event.getRight().getItem() == Blocks.REDSTONE_BLOCK.asItem())) {
			if ((event.getLeft().getCount() == 1) && (event.getRight().getCount() >= 3)) {
				event.setMaterialCost(3);
				event.setCost(4);
				event.setOutput(new ItemStack(MobExecutionModBlocks.AUTO_EXECUTION_MACHINE.get()));
			}
		}
	}
}