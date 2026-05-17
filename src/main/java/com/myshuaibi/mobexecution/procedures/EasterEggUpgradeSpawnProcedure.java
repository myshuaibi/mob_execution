package com.myshuaibi.mobexecution.procedures;

import net.neoforged.neoforge.event.entity.EntityStruckByLightningEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import java.util.Comparator;

import com.myshuaibi.mobexecution.init.MobExecutionModItems;
import com.myshuaibi.mobexecution.MobExecutionMod;

@EventBusSubscriber
public class EasterEggUpgradeSpawnProcedure {
	@SubscribeEvent
	public static void onEntityStruckByLightning(EntityStruckByLightningEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == MobExecutionModItems.EMPTY_UPGRADE_TEMPLATE.get()) {
					if (!entityiterator.level().isClientSide())
						entityiterator.discard();
					MobExecutionMod.queueServerWork(10, () -> {
						EasterEggSpawnDoProcedure.execute(world, x, y, z, (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getCount());
					});
				}
			}
		}
	}
}