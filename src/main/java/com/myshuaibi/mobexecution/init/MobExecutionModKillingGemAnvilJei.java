package com.myshuaibi.mobexecution.init;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.recipe.vanilla.IJeiAnvilRecipe;
import mezz.jei.api.registration.IRecipeRegistration;

import java.util.ArrayList;
import java.util.List;

@JeiPlugin
public class MobExecutionModKillingGemAnvilJei implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return ResourceLocation.parse("mob_execution:killing_gem_jei");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		IVanillaRecipeFactory factory = registration.getVanillaRecipeFactory();

		List<ItemStack> leftInputs = new ArrayList<>();
		List<ItemStack> outputs = new ArrayList<>();

		TagKey<Item> weaponTag = TagKey.create(BuiltInRegistries.ITEM.key(),
			ResourceLocation.parse("minecraft:enchantable/weapon"));

		BuiltInRegistries.ITEM.getTag(weaponTag).ifPresent(holders -> {
			for (var holder : holders) {
				Item item = holder.value();
				if (item == Items.AIR) continue;

				leftInputs.add(new ItemStack(item));
                
				ItemStack output = new ItemStack(item);
				CompoundTag tag = new CompoundTag();
				tag.putInt("infestation", 1);
				output.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
				outputs.add(output);
			}
		});

		if (leftInputs.isEmpty()) {
			ItemStack fallback = new ItemStack(Items.DIAMOND_SWORD);
			leftInputs.add(fallback);
			CompoundTag tag = new CompoundTag();
			tag.putInt("infestation", 1);
			ItemStack fallbackOut = fallback.copy();
			fallbackOut.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
			outputs.add(fallbackOut);
		}

		List<ItemStack> rightInputs = List.of(new ItemStack(MobExecutionModItems.KILLING_GEM.get()));

		IJeiAnvilRecipe recipe = factory.createAnvilRecipe(leftInputs, rightInputs, outputs);
		registration.addRecipes(RecipeTypes.ANVIL, List.of(recipe));
	}
}