package com.myshuaibi.mobexecution.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import java.util.Collection;

import com.myshuaibi.mobexecution.init.MobExecutionModItems;
import com.myshuaibi.mobexecution.configuration.MobExecutionCommomSetConfiguration;

@EventBusSubscriber
public class ExecutionDropsProcedure {
	@SubscribeEvent
	public static void onLivingDrops(LivingDropsEvent event) {
		if (event.getEntity() == null)
			return;
		execute(event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getDrops());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Collection<ItemEntity> drops) {
		BlockState target_block = world.getBlockState(BlockPos.containing(x, y - 1, z));
		boolean result = false;
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
			double lootingLevel = UpgradeGetProcedure.execute(world, x, y, z, new ItemStack(MobExecutionModItems.LOOTING_UPGRADE.get()));
			if (lootingLevel > 0) {
				int bonus = (int) lootingLevel;
				for (ItemEntity drop : drops) {
					ItemStack stack = drop.getItem();
					stack.setCount(stack.getCount() + bonus);
				}
			}
		}
	}
}