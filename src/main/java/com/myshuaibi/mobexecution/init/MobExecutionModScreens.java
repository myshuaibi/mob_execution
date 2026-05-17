/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.myshuaibi.mobexecution.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import com.myshuaibi.mobexecution.client.gui.MachineGuiScreen;

@EventBusSubscriber(Dist.CLIENT)
public class MobExecutionModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(MobExecutionModMenus.MACHINE_GUI.get(), MachineGuiScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}