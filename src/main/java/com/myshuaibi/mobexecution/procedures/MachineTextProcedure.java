package com.myshuaibi.mobexecution.procedures;

import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BlockItem;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

import javax.annotation.Nullable;

import java.util.List;

@EventBusSubscriber(value = {Dist.CLIENT})
public class MachineTextProcedure {
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
		if ((itemstack.getItem() instanceof BlockItem _bi ? _bi.getBlock().defaultBlockState() : Blocks.AIR.defaultBlockState()).is(BlockTags.create(ResourceLocation.parse("mob_execution:all_machine")))) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal((Component.translatable("item.mob_execution.machine.description_2").getString() + "" + DoubleTurnIntProcedure.execute(LimitHealthProcedure.execute()))));
				tooltip.add(Component.literal((Component.translatable("item.mob_execution.machine.description_3").getString())));
				tooltip.add(Component.literal((Component.translatable("item.mob_execution.machine.description_4").getString())));
				tooltip.add(Component.literal((Component.translatable("item.mob_execution.machine.description_5").getString())));
				tooltip.add(Component.literal((Component.translatable("item.mob_execution.machine.description_6").getString())));
				tooltip.add(Component.literal((Component.translatable("item.mob_execution.machine.description_7").getString())));
			} else {
				tooltip.add(Component.literal((Component.translatable("item.mob_execution.machine.description_0").getString())));
				tooltip.add(Component.literal((Component.translatable("item.mob_execution.machine.description_1").getString())));
			}
		}
	}
}