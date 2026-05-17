/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.myshuaibi.mobexecution.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import com.myshuaibi.mobexecution.block.ExecutionMachineBlock;
import com.myshuaibi.mobexecution.block.AutoExecutionMachineBlock;
import com.myshuaibi.mobexecution.MobExecutionMod;

public class MobExecutionModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(MobExecutionMod.MODID);
	public static final DeferredBlock<Block> EXECUTION_MACHINE;
	public static final DeferredBlock<Block> AUTO_EXECUTION_MACHINE;
	static {
		EXECUTION_MACHINE = REGISTRY.register("execution_machine", ExecutionMachineBlock::new);
		AUTO_EXECUTION_MACHINE = REGISTRY.register("auto_execution_machine", AutoExecutionMachineBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}