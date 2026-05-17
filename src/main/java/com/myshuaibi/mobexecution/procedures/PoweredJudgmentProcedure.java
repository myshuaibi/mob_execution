package com.myshuaibi.mobexecution.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;

import com.myshuaibi.mobexecution.init.MobExecutionModBlocks;

public class PoweredJudgmentProcedure {
	public static boolean execute(BlockState blockstate) {
		if (blockstate.is(BlockTags.create(ResourceLocation.parse("mob_execution:all_machine")))) {
			if (blockstate.getBlock() == MobExecutionModBlocks.EXECUTION_MACHINE.get()) {
				if (getPropertyByName(blockstate, "powered") instanceof BooleanProperty _getbp5 && blockstate.getValue(_getbp5)) {
					return true;
				}
			}
			if (blockstate.getBlock() == MobExecutionModBlocks.AUTO_EXECUTION_MACHINE.get()) {
				return true;
			}
		}
		return false;
	}

	private static Property<?> getPropertyByName(BlockState state, String name) {
		for (Property<?> property : state.getProperties()) {
			if (property.getName().equals(name)) {
				return property;
			}
		}
		return null;
	}
}