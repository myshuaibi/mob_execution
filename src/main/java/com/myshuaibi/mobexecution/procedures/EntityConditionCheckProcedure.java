package com.myshuaibi.mobexecution.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import com.myshuaibi.mobexecution.init.MobExecutionModItems;

public class EntityConditionCheckProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		double health = 0;
		Entity ent = null;
		if (MachineLordJudgmentProcedure.execute(world, x, y - 1, z, entity)) {
			return false;
		}
		if (!(UpgradeGetProcedure.execute(world, x, y, z, new ItemStack(MobExecutionModItems.CREATE_UPGRADE.get())) > 0)) {
			if (!(UpgradeGetProcedure.execute(world, x, y, z, new ItemStack(MobExecutionModItems.LIMIT_BREAK_HIGH_UPGRADE.get())) > 0)) {
				if ((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity0.getAttribute(Attributes.MAX_HEALTH).getValue() : 0) > LimitHealthProcedure.execute()) {
					return false;
				}
			}
			if (UpgradeGetProcedure.execute(world, x, y, z, new ItemStack(MobExecutionModItems.LIMIT_BREAK_HIGH_UPGRADE.get())) > 0) {
				if (entity instanceof Player) {
					return false;
				}
			} else {
				if (!(entity instanceof Enemy)) {
					return false;
				}
			}
			if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("c:boss")))) {
				return false;
			}
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				return false;
			}
			if (!(UpgradeGetProcedure.execute(world, x, y, z, new ItemStack(MobExecutionModItems.LIMIT_BREAK_UPGRADE.get())) > 0)) {
				if (!(GetNameSpaceProcedure.execute(entity)).equals("minecraft")) {
					return false;
				}
			}
		}
		return true;
	}
}