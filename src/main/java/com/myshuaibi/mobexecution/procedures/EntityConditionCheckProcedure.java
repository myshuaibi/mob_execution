package com.myshuaibi.mobexecution.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import com.myshuaibi.mobexecution.configuration.MobExecutionCommomSetConfiguration;

public class EntityConditionCheckProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		double health = 0;
		if (MachineLordJudgmentProcedure.execute(world, x, y - 1, z, entity)) {
			return false;
		}
		if (!(UpgradeGetProcedure.execute(world, x, y, z, "create") > 0)) {
			if ((double) MobExecutionCommomSetConfiguration.LIMIT_MAX_HEALTH.get() >= 0) {
				health = (double) MobExecutionCommomSetConfiguration.LIMIT_MAX_HEALTH.get();
			} else {
				health = Double.POSITIVE_INFINITY;
			}
			if ((entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity2.getAttribute(Attributes.MAX_HEALTH).getValue() : 0) > health) {
				return false;
			}
			if (!(entity instanceof Monster)) {
				return false;
			}
			if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("c:boss")))) {
				return false;
			}
			if (entity instanceof Mob _mobEnt5 && _mobEnt5.isAggressive()) {
				return false;
			}
			if (!(GetNameSpaceProcedure.execute(entity)).equals("minecraft")) {
				return false;
			}
		}
		return true;
	}
}