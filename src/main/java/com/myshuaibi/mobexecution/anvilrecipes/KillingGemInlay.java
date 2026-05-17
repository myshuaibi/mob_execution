package com.myshuaibi.mobexecution.anvilrecipes;

import net.neoforged.neoforge.event.AnvilUpdateEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.nbt.CompoundTag;

import com.myshuaibi.mobexecution.init.MobExecutionModItems;

@EventBusSubscriber
public class KillingGemInlay {
    private static final TagKey<net.minecraft.world.item.Item> ENCHANTABLE_WEAPON = ItemTags.create(ResourceLocation.parse("minecraft:enchantable/weapon"));
    private static final int MAX_INLAY = 3;
    private static final int XP_COST = 6;

    @SubscribeEvent
    public static void execute(AnvilUpdateEvent event) {
        ItemStack leftItem = event.getLeft();
        ItemStack rightItem = event.getRight();

        if (rightItem.getItem() != MobExecutionModItems.KILLING_GEM.get()) return;
        if (leftItem.getCount() != 1 || rightItem.getCount() < 1) return;
        if (!leftItem.is(ENCHANTABLE_WEAPON)) return;

        int currentInlay = getInlayCount(leftItem);
        if (currentInlay >= MAX_INLAY) return;

        ItemStack output = leftItem.copy();
        setInlayCount(output, currentInlay + 1);

        event.setOutput(output);
        event.setCost(XP_COST);
        event.setMaterialCost(1);
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
}