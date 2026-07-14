package com.myshuaibi.mobexecution.anvilrecipes;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.AnvilUpdateEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.component.DataComponents;

import com.myshuaibi.mobexecution.init.MobExecutionModMobEffects;
import com.myshuaibi.mobexecution.init.MobExecutionModItems;

@EventBusSubscriber
public class KillingGemInlay {
	private static final TagKey<net.minecraft.world.item.Item> ENCHANTABLE_WEAPON = ItemTags.create(ResourceLocation.parse("minecraft:enchantable/weapon"));
	private static final int MAX_INLAY = 3;
	private static final int XP_COST = 6;

	@SubscribeEvent
	public static void onAnvilUpdate(AnvilUpdateEvent event) {
		ItemStack leftItem = event.getLeft();
		ItemStack rightItem = event.getRight();
		if (rightItem.getItem() != MobExecutionModItems.KILLING_GEM.get())
			return;
		if (leftItem.getCount() != 1 || rightItem.getCount() < 1)
			return;
		if (!leftItem.is(ENCHANTABLE_WEAPON))
			return;
		int currentInlay = getInlayCount(leftItem);
		Player player = event.getPlayer();
		if (currentInlay >= MAX_INLAY && (player == null || !player.isCreative())) {
			event.setOutput(ItemStack.EMPTY);
			event.setCanceled(true);
			return;
		}
		ItemStack output = leftItem.copy();
		setInlayCount(output, currentInlay + 1);
		addPendingEffectTag(output);
		event.setOutput(output);
		event.setCost(XP_COST);
		event.setMaterialCost(1);
	}

	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Pre event) {
		Player player = event.getEntity();
		if (player.level().isClientSide())
			return;
		for (ItemStack stack : player.getInventory().items) {
			if (hasPendingEffectTag(stack)) {
				player.addEffect(new MobEffectInstance(MobExecutionModMobEffects.KILLING_INTENT, 30 * 20, 3, false, true));
				player.closeContainer();
				removePendingEffectTag(stack);
				break;
			}
		}
	}

	private static int getInlayCount(ItemStack stack) {
		CustomData customData = stack.get(DataComponents.CUSTOM_DATA);
		if (customData != null) {
			CompoundTag tag = customData.copyTag();
			if (tag.contains("infestation")) {
				return tag.getInt("infestation");
			}
		}
		return 0;
	}

	private static void setInlayCount(ItemStack stack, int count) {
		CustomData original = stack.get(DataComponents.CUSTOM_DATA);
		CompoundTag tag = (original != null) ? original.copyTag() : new CompoundTag();
		tag.putInt("infestation", count);
		stack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
	}

	private static void addPendingEffectTag(ItemStack stack) {
		CustomData original = stack.get(DataComponents.CUSTOM_DATA);
		CompoundTag tag = (original != null) ? original.copyTag() : new CompoundTag();
		tag.putBoolean("pendingKillingIntent", true);
		stack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
	}

	private static boolean hasPendingEffectTag(ItemStack stack) {
		CustomData customData = stack.get(DataComponents.CUSTOM_DATA);
		if (customData != null) {
			CompoundTag tag = customData.copyTag();
			return tag.getBoolean("pendingKillingIntent");
		}
		return false;
	}

	private static void removePendingEffectTag(ItemStack stack) {
		CustomData original = stack.get(DataComponents.CUSTOM_DATA);
		if (original != null) {
			CompoundTag tag = original.copyTag();
			tag.remove("pendingKillingIntent");
			stack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
		}
	}
}