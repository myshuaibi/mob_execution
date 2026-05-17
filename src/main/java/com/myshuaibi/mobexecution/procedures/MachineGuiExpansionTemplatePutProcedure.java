package com.myshuaibi.mobexecution.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class MachineGuiExpansionTemplatePutProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("mob_execution:expansion_template")))) {
			return false;
		}
		return true;
	}
}