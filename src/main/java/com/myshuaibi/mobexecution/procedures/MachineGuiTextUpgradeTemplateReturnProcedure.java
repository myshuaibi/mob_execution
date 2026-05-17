package com.myshuaibi.mobexecution.procedures;

import net.minecraft.network.chat.Component;

public class MachineGuiTextUpgradeTemplateReturnProcedure {
	public static String execute() {
		return Component.translatable("gui.mob_execution.upgrade.title").getString();
	}
}