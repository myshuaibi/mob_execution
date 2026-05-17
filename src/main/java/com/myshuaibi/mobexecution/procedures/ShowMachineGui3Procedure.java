package com.myshuaibi.mobexecution.procedures;

import net.minecraft.world.entity.Entity;

public class ShowMachineGui3Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (ExpansionDetectionProcedure.execute(entity) < 3) {
			return true;
		}
		return false;
	}
}