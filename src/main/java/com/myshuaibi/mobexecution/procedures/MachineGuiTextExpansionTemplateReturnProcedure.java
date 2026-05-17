package com.myshuaibi.mobexecution.procedures;

import net.minecraft.network.chat.Component;

public class MachineGuiTextExpansionTemplateReturnProcedure {
	public static String execute() {
		return Component.translatable("gui.mob_execution.expansion.title").getString();
	}
}