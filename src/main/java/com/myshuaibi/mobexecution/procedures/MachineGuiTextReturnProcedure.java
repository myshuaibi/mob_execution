package com.myshuaibi.mobexecution.procedures;

import net.minecraft.network.chat.Component;

public class MachineGuiTextReturnProcedure {
	public static String execute() {
		return Component.translatable("gui.mob_execution.machine.title").getString();
	}
}