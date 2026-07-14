package com.myshuaibi.mobexecution.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import com.myshuaibi.mobexecution.procedures.KillingIntentUseProcedure;
import com.myshuaibi.mobexecution.procedures.KillingIntentStartProcedure;
import com.myshuaibi.mobexecution.procedures.KillingIntentDoProcedure;
import com.myshuaibi.mobexecution.MobExecutionMod;

public class KillingIntentMobEffect extends MobEffect {
	public KillingIntentMobEffect() {
		super(MobEffectCategory.HARMFUL, -3663586);
		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(MobExecutionMod.MODID, "effect.killing_intent_0"), 1.5, AttributeModifier.Operation.ADD_VALUE);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		KillingIntentStartProcedure.execute(entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return KillingIntentUseProcedure.execute(duration);
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		KillingIntentDoProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, amplifier);
		return super.applyEffectTick(entity, amplifier);
	}
}