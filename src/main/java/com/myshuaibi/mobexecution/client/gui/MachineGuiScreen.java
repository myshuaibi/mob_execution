package com.myshuaibi.mobexecution.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import com.myshuaibi.mobexecution.world.inventory.MachineGuiMenu;
import com.myshuaibi.mobexecution.procedures.*;
import com.myshuaibi.mobexecution.init.MobExecutionModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class MachineGuiScreen extends AbstractContainerScreen<MachineGuiMenu> implements MobExecutionModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("mob_execution:textures/screens/machine_gui.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("mob_execution:textures/screens/hide_level_machinegui.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("mob_execution:textures/screens/hide_level_machinegui.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("mob_execution:textures/screens/hide_level_machinegui.png");

	public MachineGuiScreen(MachineGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 198;
		this.imageHeight = 198;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		if (ShowMachineGui1Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_0, this.leftPos + 134, this.topPos + 68, 0, 0, 18, 18, 18, 18);
		}
		if (ShowMachineGui2Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_1, this.leftPos + 161, this.topPos + 68, 0, 0, 18, 18, 18, 18);
		}
		if (ShowMachineGui3Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_2, this.leftPos + 134, this.topPos + 95, 0, 0, 18, 18, 18, 18);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, MachineGuiTextReturnProcedure.execute(), 8, 5, -13421773, false);
		guiGraphics.drawString(this.font, MachineGuiTextExpansionTemplateReturnProcedure.execute(), 8, 68, -13421773, false);
		guiGraphics.drawString(this.font, MachineGuiTextUpgradeTemplateReturnProcedure.execute(), 134, 2, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}