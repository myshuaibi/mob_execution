/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.myshuaibi.mobexecution.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import com.myshuaibi.mobexecution.MobExecutionMod;

public class MobExecutionModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, MobExecutionMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_EXECUTION_MACHINE_USE = REGISTRY.register("block.execution_machine.use",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("mob_execution", "block.execution_machine.use")));
}