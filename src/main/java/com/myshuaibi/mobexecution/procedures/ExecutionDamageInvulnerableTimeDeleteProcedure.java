package com.myshuaibi.mobexecution.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ExecutionDamageInvulnerableTimeDeleteProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getSource());
		}
	}

	public static void execute(DamageSource damagesource) {
		execute(null, damagesource);
	}

	private static void execute(@Nullable Event event, DamageSource damagesource) {
		if (damagesource == null)
			return;
		if (damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("mob_execution:execution_damage")))) {
			if (event instanceof LivingIncomingDamageEvent _event) {
				_event.setInvulnerabilityTicks(0);
			}
		}
	}
}