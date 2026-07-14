/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.myshuaibi.mobexecution.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import com.myshuaibi.mobexecution.MobExecutionMod;

@EventBusSubscriber
public class MobExecutionModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MobExecutionMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MOB_EXECUTION = REGISTRY.register("mob_execution",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.mob_execution.mob_execution")).icon(() -> new ItemStack(MobExecutionModBlocks.AUTO_EXECUTION_MACHINE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(MobExecutionModBlocks.EXECUTION_MACHINE.get().asItem());
				tabData.accept(MobExecutionModBlocks.AUTO_EXECUTION_MACHINE.get().asItem());
				tabData.accept(MobExecutionModItems.COARSE_RUBY.get());
				tabData.accept(MobExecutionModItems.KILLING_GEM.get());
				tabData.accept(MobExecutionModItems.EMPTY_UPGRADE_TEMPLATE.get());
				tabData.accept(MobExecutionModItems.CREATE_UPGRADE.get());
				tabData.accept(MobExecutionModItems.INFINITE_UPGRADE.get());
				tabData.accept(MobExecutionModItems.LIMIT_BREAK_UPGRADE.get());
				tabData.accept(MobExecutionModItems.LIMIT_BREAK_HIGH_UPGRADE.get());
				tabData.accept(MobExecutionModItems.EFFICIENCY_UPGRADE.get());
				tabData.accept(MobExecutionModItems.EFFICIENCY_UPGRADE_HIGH.get());
				tabData.accept(MobExecutionModItems.LOOTING_UPGRADE.get());
				tabData.accept(MobExecutionModItems.LOOTING_UPGRADE_HIGH.get());
				tabData.accept(MobExecutionModItems.REAL_DAMAGE_UPGRADE.get());
				tabData.accept(MobExecutionModItems.REGENERATION_UPGRADE.get());
				tabData.accept(MobExecutionModItems.SIMULATE_UPGRADE.get());
				tabData.accept(MobExecutionModItems.TRANSMISSION_UPGRADE.get());
				tabData.accept(MobExecutionModItems.EMPTY_EXPANSION_TEMPLATE.get());
				tabData.accept(MobExecutionModItems.OVERWORLD_EXPANSION_TEMPLATE.get());
				tabData.accept(MobExecutionModItems.NETHER_EXPANSION_TEMPLATE.get());
				tabData.accept(MobExecutionModItems.END_EXPANSION_TEMPLATE.get());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
			tabData.accept(MobExecutionModBlocks.EXECUTION_MACHINE.get().asItem());
			tabData.accept(MobExecutionModBlocks.AUTO_EXECUTION_MACHINE.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
			tabData.accept(MobExecutionModBlocks.EXECUTION_MACHINE.get().asItem());
			tabData.accept(MobExecutionModBlocks.AUTO_EXECUTION_MACHINE.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(MobExecutionModItems.KILLING_GEM.get());
		}
	}
}