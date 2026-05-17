package com.myshuaibi.mobexecution.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.BuiltInRegistries;

public class GetNameSpaceProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String namespace = "";
		namespace = (BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).substring(0, (BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).indexOf(":", 0));
		return namespace;
	}
}