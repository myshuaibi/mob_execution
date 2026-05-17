package com.myshuaibi.mobexecution.procedures;

import net.neoforged.neoforge.server.ServerLifecycleHooks;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.MinecraftServer;

import java.util.UUID;

public class GetLordFromUuidProcedure {
	public static Entity execute(String text) {
		if (text == null)
			return null;
		Entity target_entity = null;
		String str = "";
		str = text;
		try {
			UUID uuid = UUID.fromString(str);
			MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
			if (server != null) {
				for (ServerLevel level : server.getAllLevels()) {
					target_entity = level.getEntity(uuid);
					if (target_entity != null)
						break;
				}
			}
		} catch (IllegalArgumentException ignored) {
		}
		return target_entity;
	}
}