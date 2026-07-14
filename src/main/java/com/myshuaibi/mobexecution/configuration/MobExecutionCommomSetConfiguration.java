package com.myshuaibi.mobexecution.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class MobExecutionCommomSetConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;
	public static final ModConfigSpec.ConfigValue<Double> BASIC_EXECUTION;
	public static final ModConfigSpec.ConfigValue<Double> LIMIT_MAX_HEALTH;
	public static final ModConfigSpec.ConfigValue<Boolean> PRECISION_MODE;
	public static final ModConfigSpec.ConfigValue<Boolean> MACHINE_PROTECTION;
	public static final ModConfigSpec.ConfigValue<Double> INFESTATION_AMOUNT;
	static {
		BASIC_EXECUTION = BUILDER.define("basic_execution", (double) 1);
		LIMIT_MAX_HEALTH = BUILDER.define("limit_max_health", (double) 60);
		PRECISION_MODE = BUILDER.define("precision_mode", false);
		MACHINE_PROTECTION = BUILDER.define("machine_protection", true);
		INFESTATION_AMOUNT = BUILDER.define("infestation_amount", (double) 0.12);

		SPEC = BUILDER.build();
	}

}