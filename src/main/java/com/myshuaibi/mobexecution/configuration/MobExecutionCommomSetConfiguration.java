package com.myshuaibi.mobexecution.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class MobExecutionCommomSetConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;
	public static final ModConfigSpec.ConfigValue<Double> LIMIT_MAX_HEALTH;
	public static final ModConfigSpec.ConfigValue<Double> BASIC_EXECUTION;
	public static final ModConfigSpec.ConfigValue<Boolean> MACHINE_PROTECTION;
	public static final ModConfigSpec.ConfigValue<Boolean> PRECISION_MODE;
	public static final ModConfigSpec.ConfigValue<Double> INFESTATION_AMOUNT;
	static {
		LIMIT_MAX_HEALTH = BUILDER.comment("Decide the entity health limit in the execution machine").define("limit_max_health", (double) 60);
		BASIC_EXECUTION = BUILDER.comment("Determine the basic machine damage per tick").define("basic_execution", (double) 1);
		MACHINE_PROTECTION = BUILDER.comment("Once enabled, machines placed by others cannot be destroyed in non-creative mode.").define("machine_protection", true);
		PRECISION_MODE = BUILDER.comment("After being enabled, only entities killed by execution damage are considered machine kills.").define("precision_mode", true);
		INFESTATION_AMOUNT = BUILDER.comment("Determines the single-use bonus provided by socketing the killing gem").define("infestation_amount", (double) 0.12);

		SPEC = BUILDER.build();
	}

}