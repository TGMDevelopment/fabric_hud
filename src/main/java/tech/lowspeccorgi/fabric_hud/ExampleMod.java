package tech.lowspeccorgi.fabric_hud;

import org.lwjgl.glfw.GLFW;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import tech.lowspeccorgi.fabric_hud.elements.Element;
import tech.lowspeccorgi.fabric_hud.elements.ElementManager;
import tech.lowspeccorgi.fabric_hud.elements.element.fpsElement;
import tech.lowspeccorgi.fabric_hud.huds.DraggableHud;

public class ExampleMod implements ModInitializer {
	private KeyBinding keyBinding;
	public static int fps;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Element testtElement = new fpsElement();
		ElementManager elementManager = new ElementManager(testtElement);

		keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.fabric_hud.open_hud",
				InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_R, "category.fabric_hud_test"));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (keyBinding.wasPressed()) {
				MinecraftClient.getInstance().openScreen(new DraggableHud(elementManager));
			}
		});
	}
}
