/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.myshuaibi.mobexecution.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import com.myshuaibi.mobexecution.item.*;
import com.myshuaibi.mobexecution.MobExecutionMod;

public class MobExecutionModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(MobExecutionMod.MODID);
	public static final DeferredItem<Item> EXECUTION_MACHINE;
	public static final DeferredItem<Item> AUTO_EXECUTION_MACHINE;
	public static final DeferredItem<Item> EMPTY_UPGRADE_TEMPLATE;
	public static final DeferredItem<Item> OVERWORLD_EXPANSION_TEMPLATE;
	public static final DeferredItem<Item> NETHER_EXPANSION_TEMPLATE;
	public static final DeferredItem<Item> END_EXPANSION_TEMPLATE;
	public static final DeferredItem<Item> EMPTY_EXPANSION_TEMPLATE;
	public static final DeferredItem<Item> EASTER_EGG_UPGRADE;
	public static final DeferredItem<Item> CREATE_UPGRADE;
	public static final DeferredItem<Item> EFFICIENCY_UPGRADE;
	public static final DeferredItem<Item> EFFICIENCY_UPGRADE_HIGH;
	public static final DeferredItem<Item> REGENERATION_UPGRADE;
	public static final DeferredItem<Item> SIMULATE_UPGRADE;
	public static final DeferredItem<Item> REAL_DAMAGE_UPGRADE;
	public static final DeferredItem<Item> COARSE_RUBY;
	public static final DeferredItem<Item> KILLING_GEM;
	public static final DeferredItem<Item> TRANSMISSION_UPGRADE;
	public static final DeferredItem<Item> LOOTING_UPGRADE;
	public static final DeferredItem<Item> LOOTING_UPGRADE_HIGH;
	public static final DeferredItem<Item> LIMIT_BREAK_UPGRADE;
	public static final DeferredItem<Item> LIMIT_BREAK_HIGH_UPGRADE;
	public static final DeferredItem<Item> INFINITE_UPGRADE;
	static {
		EXECUTION_MACHINE = block(MobExecutionModBlocks.EXECUTION_MACHINE);
		AUTO_EXECUTION_MACHINE = block(MobExecutionModBlocks.AUTO_EXECUTION_MACHINE);
		EMPTY_UPGRADE_TEMPLATE = REGISTRY.register("empty_upgrade_template", EmptyUpgradeTemplateItem::new);
		OVERWORLD_EXPANSION_TEMPLATE = REGISTRY.register("overworld_expansion_template", OverworldExpansionTemplateItem::new);
		NETHER_EXPANSION_TEMPLATE = REGISTRY.register("nether_expansion_template", NetherExpansionTemplateItem::new);
		END_EXPANSION_TEMPLATE = REGISTRY.register("end_expansion_template", EndExpansionTemplateItem::new);
		EMPTY_EXPANSION_TEMPLATE = REGISTRY.register("empty_expansion_template", EmptyExpansionTemplateItem::new);
		EASTER_EGG_UPGRADE = REGISTRY.register("easter_egg_upgrade", EasterEggUpgradeItem::new);
		CREATE_UPGRADE = REGISTRY.register("create_upgrade", CreateUpgradeItem::new);
		EFFICIENCY_UPGRADE = REGISTRY.register("efficiency_upgrade", EfficiencyUpgradeItem::new);
		EFFICIENCY_UPGRADE_HIGH = REGISTRY.register("efficiency_upgrade_high", EfficiencyUpgradeHighItem::new);
		REGENERATION_UPGRADE = REGISTRY.register("regeneration_upgrade", RegenerationUpgradeItem::new);
		SIMULATE_UPGRADE = REGISTRY.register("simulate_upgrade", SimulateUpgradeItem::new);
		REAL_DAMAGE_UPGRADE = REGISTRY.register("real_damage_upgrade", RealDamageUpgradeItem::new);
		COARSE_RUBY = REGISTRY.register("coarse_ruby", CoarseRubyItem::new);
		KILLING_GEM = REGISTRY.register("killing_gem", KillingGemItem::new);
		TRANSMISSION_UPGRADE = REGISTRY.register("transmission_upgrade", TransmissionUpgradeItem::new);
		LOOTING_UPGRADE = REGISTRY.register("looting_upgrade", LootingUpgradeItem::new);
		LOOTING_UPGRADE_HIGH = REGISTRY.register("looting_upgrade_high", LootingUpgradeHighItem::new);
		LIMIT_BREAK_UPGRADE = REGISTRY.register("limit_break_upgrade", LimitBreakUpgradeItem::new);
		LIMIT_BREAK_HIGH_UPGRADE = REGISTRY.register("limit_break_high_upgrade", LimitBreakHighUpgradeItem::new);
		INFINITE_UPGRADE = REGISTRY.register("infinite_upgrade", InfiniteUpgradeItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}