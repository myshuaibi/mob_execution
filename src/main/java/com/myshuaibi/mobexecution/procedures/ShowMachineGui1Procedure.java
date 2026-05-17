package com.myshuaibi.mobexecution.procedures;

import net.minecraft.world.entity.Entity;

public class ShowMachineGui1Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (ExpansionDetectionProcedure.execute(entity) < 1) {
			return true;
		}
		return false;
	}
}