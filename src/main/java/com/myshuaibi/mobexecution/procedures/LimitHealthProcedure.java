package com.myshuaibi.mobexecution.procedures;

import com.myshuaibi.mobexecution.configuration.MobExecutionCommomSetConfiguration;

public class LimitHealthProcedure {
	public static double execute() {
		double health = 0;
		if ((double) MobExecutionCommomSetConfiguration.LIMIT_MAX_HEALTH.get() >= 0) {
			health = (double) MobExecutionCommomSetConfiguration.LIMIT_MAX_HEALTH.get();
		} else {
			health = Double.POSITIVE_INFINITY;
		}
		return health;
	}
}