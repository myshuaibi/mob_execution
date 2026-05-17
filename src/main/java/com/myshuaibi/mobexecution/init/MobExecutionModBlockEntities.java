/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.myshuaibi.mobexecution.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import com.myshuaibi.mobexecution.block.entity.ExecutionMachineBlockEntity;
import com.myshuaibi.mobexecution.block.entity.AutoExecutionMachineBlockEntity;
import com.myshuaibi.mobexecution.MobExecutionMod;

@EventBusSubscriber
public class MobExecutionModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MobExecutionMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ExecutionMachineBlockEntity>> EXECUTION_MACHINE = register("execution_machine", MobExecutionModBlocks.EXECUTION_MACHINE, ExecutionMachineBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AutoExecutionMachineBlockEntity>> AUTO_EXECUTION_MACHINE = register("auto_execution_machine", MobExecutionModBlocks.AUTO_EXECUTION_MACHINE,
			AutoExecutionMachineBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, EXECUTION_MACHINE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, AUTO_EXECUTION_MACHINE.get(), SidedInvWrapper::new);
	}
}