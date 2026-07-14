package com.myshuaibi.mobexecution.procedures;

import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

import java.util.List;

import com.myshuaibi.mobexecution.init.MobExecutionModItems;

@EventBusSubscriber(value = {Dist.CLIENT})
public class LootingUpgradeTextProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getItemStack(), event.getToolTip());
	}

	public static void execute(ItemStack itemstack, List<Component> tooltip) {
		execute(null, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
		if (tooltip == null)
			return;
		if (itemstack.getItem() == MobExecutionModItems.LOOTING_UPGRADE.get()) {
			tooltip.add(Component.literal((Component.translatable("item.mob_execution.looting_upgrade.description_0").getString() + "1")));
		}
		if (itemstack.getItem() == MobExecutionModItems.LOOTING_UPGRADE_HIGH.get()) {
			tooltip.add(Component.literal((Component.translatable("item.mob_execution.looting_upgrade.description_0").getString() + "2")));
		}
	}
}