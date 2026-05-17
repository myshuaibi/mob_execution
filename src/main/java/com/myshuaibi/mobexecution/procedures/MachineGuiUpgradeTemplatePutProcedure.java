package com.myshuaibi.mobexecution.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.UUID;

public class MachineGuiUpgradeTemplatePutProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack, double slot) {
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("mob_execution:upgrade_template")))) {
			if (slot > 6 + ExpansionDetectionProcedure.execute(world instanceof ServerLevel _level3 ? getEntityFromUUID(_level3, (getBlockNBTString(world, BlockPos.containing(x, y, z), "lord"))) : null)) {
				return true;
			}
			return false;
		}
		return true;
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}

	private static Entity getEntityFromUUID(ServerLevel level, String uuid) {
		try {
			return level.getEntity(UUID.fromString(uuid));
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
}