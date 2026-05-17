package com.myshuaibi.mobexecution.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import com.myshuaibi.mobexecution.configuration.MobExecutionCommomSetConfiguration;

public class ExecutionDamageProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double multiple = 0;
		Entity sourceentity = null;
		multiple = UpgradeGetProcedure.execute(world, x, y, z, "efficiency");
		if (!(multiple > 0)) {
			multiple = 1;
		}
		if (UpgradeGetProcedure.execute(world, x, y, z, "simulate") > 0) {
			if (!world.isClientSide()) {
				sourceentity = GetLordFromUuidProcedure.execute(getBlockNBTString(world, BlockPos.containing(x, y - 1, z), "lord"));
			}
		}
		if (UpgradeGetProcedure.execute(world, x, y, z, "create") > 0) {
			entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("mob_execution:execution_real_advanced"))), sourceentity), (float) (3.4 * Math.pow(10, 38)));
		} else if (UpgradeGetProcedure.execute(world, x, y, z, "real_damage") > 0) {
			entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("mob_execution:execution_real"))), sourceentity),
					(float) ((double) MobExecutionCommomSetConfiguration.BASIC_EXECUTION.get() * multiple));
		} else {
			entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("mob_execution:execution_common"))), sourceentity),
					(float) ((double) MobExecutionCommomSetConfiguration.BASIC_EXECUTION.get() * multiple));
		}
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}
}