package com.myshuaibi.mobexecution.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import com.myshuaibi.mobexecution.MobExecutionMod;

public class RegenerationDoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity spawned = null;
		double i = 0;
		if (world instanceof ServerLevel level) {
			EntityType<?> type = entity.getType();
			spawned = type.spawn(level, BlockPos.containing(x, y + 0.3, z), MobSpawnType.MOB_SUMMONED);
			if (spawned != null) {
				spawned.setYRot(world.getRandom().nextFloat() * 360F);
			}
		}
		if (spawned instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 30, 4));
		if (spawned instanceof LivingEntity _entity) {
			ItemStack _setstack1 = new ItemStack(Blocks.AIR).copy();
			_setstack1.setCount(1);
			_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack1);
			ItemStack _setstack2 = new ItemStack(Blocks.AIR).copy();
			_setstack2.setCount(1);
			_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack2);
			if (_entity instanceof Player _player)
				_player.getInventory().setChanged();
		}
		for (int index0 = 0; index0 < 4; index0++) {
			{
				Entity _entity = spawned;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set((int) index0, new ItemStack(Blocks.AIR));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(new Object() {
						public static EquipmentSlot armorSlotByIndex(int _slotindex) {
							for (EquipmentSlot _slot : EquipmentSlot.values()) {
								if (_slot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR && _slot.getIndex() == _slotindex) {
									return _slot;
								}
							}
							throw new IllegalArgumentException("Invalid slot index: " + _slotindex);
						}
					}.armorSlotByIndex((int) index0), new ItemStack(Blocks.AIR));
				}
			}
		}
		if (false) {
			MobExecutionMod.LOGGER.info(x);
			MobExecutionMod.LOGGER.info(y);
			MobExecutionMod.LOGGER.info(z);
			MobExecutionMod.LOGGER.info(world.isClientSide());
			MobExecutionMod.LOGGER.info(entity);
		}
	}
}