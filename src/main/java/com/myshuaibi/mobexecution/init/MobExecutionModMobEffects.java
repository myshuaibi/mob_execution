/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.myshuaibi.mobexecution.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import com.myshuaibi.mobexecution.potion.KillingIntentMobEffect;
import com.myshuaibi.mobexecution.MobExecutionMod;

public class MobExecutionModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, MobExecutionMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> KILLING_INTENT = REGISTRY.register("killing_intent", () -> new KillingIntentMobEffect());
}