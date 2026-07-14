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
public class LimitBreakTextProcedure {
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
		if (itemstack.getItem() == MobExecutionModItems.LIMIT_BREAK_UPGRADE.get()) {
			tooltip.add(Component.literal((Component.translatable("item.mob_execution.limit_break_upgrade.description_0").getString())));
		}
		if (itemstack.getItem() == MobExecutionModItems.LIMIT_BREAK_HIGH_UPGRADE.get()) {
			tooltip.add(Component.literal((Component.translatable("item.mob_execution.limit_break_high_upgrade.description_0").getString())));
			tooltip.add(Component.literal((Component.translatable("item.mob_execution.limit_break_high_upgrade.description_1").getString())));
		}
	}
}