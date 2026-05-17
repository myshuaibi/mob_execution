package com.myshuaibi.mobexecution.init;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.recipe.vanilla.IJeiAnvilRecipe;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.List;
import java.util.ArrayList;

@JeiPlugin
public class MobExecutionModAnvilRecipes implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return ResourceLocation.parse("mob_execution:anvil_recipes");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		IVanillaRecipeFactory factory = registration.getVanillaRecipeFactory();
		List<IJeiAnvilRecipe> anvilRecipes = new ArrayList<>();
		ItemStack rightItem = ItemStack.EMPTY;
		rightItem = new ItemStack(Blocks.REDSTONE_BLOCK);
		rightItem.setCount(3);
		anvilRecipes.add(factory.createAnvilRecipe(new ItemStack(MobExecutionModBlocks.EXECUTION_MACHINE.get()), List.of(rightItem.copy()), List.of(new ItemStack(MobExecutionModBlocks.AUTO_EXECUTION_MACHINE.get()))));
		rightItem = new ItemStack(Items.TOTEM_OF_UNDYING);
		rightItem.setCount(1);
		anvilRecipes.add(factory.createAnvilRecipe(new ItemStack(MobExecutionModItems.EMPTY_UPGRADE_TEMPLATE.get()), List.of(rightItem.copy()), List.of(new ItemStack(MobExecutionModItems.REGENERATION_UPGRADE.get()))));
		registration.addRecipes(RecipeTypes.ANVIL, anvilRecipes);
	}
}