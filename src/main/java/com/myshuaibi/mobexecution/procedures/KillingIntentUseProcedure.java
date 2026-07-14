package com.myshuaibi.mobexecution.procedures;

public class KillingIntentUseProcedure {
	public static boolean execute(double duration) {
		if (duration % 40 == 0) {
			return true;
		}
		return false;
	}
}