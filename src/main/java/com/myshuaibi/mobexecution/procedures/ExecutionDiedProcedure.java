package com.myshuaibi.mobexecution.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import com.myshuaibi.mobexecution.configuration.MobExecutionCommomSetConfiguration;

@EventBusSubscriber
public class ExecutionDiedProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity) {
		execute(null, world, x, y, z, damagesource, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity) {
		if (damagesource == null || entity == null)
			return;
		BlockState target_block = Blocks.AIR.defaultBlockState();
		boolean result = false;
		double tmp = 0;
		target_block = (world.getBlockState(BlockPos.containing(x, y - 1, z)));
		if (PoweredJudgmentProcedure.execute(target_block)) {
			if (MobExecutionCommomSetConfiguration.PRECISION_MODE.get()) {
				if (damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("mob_execution:execution_damage")))) {
					result = true;
				}
			} else {
				result = true;
			}
		}
		if (result) {
			if (UpgradeGetProcedure.execute(world, x, y, z, "easter_egg") > 0) {
				EasterEggDoProcedure.execute(world, x, y, z);
			}
			if (UpgradeGetProcedure.execute(world, x, y, z, "regeneration") > 0) {
				tmp = UpgradeGetProcedure.execute(world, x, y, z, "regeneration");
				if (!(entity instanceof Player)) {
					if (Math.random() < 0.2 * tmp) {
						RegenerationDoProcedure.execute(world, x, y, z, entity);
					}
				}
			}
		}
	}
}