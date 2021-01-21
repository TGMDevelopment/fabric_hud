package tech.lowspeccorgi.fabric_hud.mixin;

import net.minecraft.client.MinecraftClient;
import tech.lowspeccorgi.fabric_hud.ExampleMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class ExampleMixin {
	@Shadow
	private static int currentFps;

	@Inject(at = @At("TAIL"), method = "render(Z)V")
	private void render(CallbackInfo info) {
		setFps(currentFps);
	}

	private static void setFps(int fps) {
		ExampleMod.fps = fps;
	}
}
