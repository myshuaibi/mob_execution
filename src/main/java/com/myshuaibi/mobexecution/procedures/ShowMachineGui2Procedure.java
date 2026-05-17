package com.myshuaibi.mobexecution.procedures;

import net.minecraft.world.entity.Entity;

public class ShowMachineGui2Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (ExpansionDetectionProcedure.execute(entity) < 2) {
			return true;
		}
		return false;
	}
}