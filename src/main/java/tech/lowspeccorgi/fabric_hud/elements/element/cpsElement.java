package tech.lowspeccorgi.fabric_hud.elements.element;

import java.util.ArrayList;
import java.util.List;
import org.lwjgl.glfw.GLFW;
import net.minecraft.client.MinecraftClient;
import tech.lowspeccorgi.fabric_hud.elements.Element;

public class cpsElement extends Element {
    private List<Long> clicks = new ArrayList<>();
    private boolean wasPressed = false;
    private long wasLastPressed;

    public cpsElement() {
        super(true, 0.0, 0.0);
        super.text = "CPS";
    }

    @Override
    public cpsElement getInstanceOfElement() {
        return new cpsElement();
    }

    @Override
    public String getDesc() {
        return "Shows your current CPS";
    }

    @Override
    public void updateElement() {
        int cps = getLeftClickCPS();
        super.text = "CPS: " + cps;
    }

    private int getLeftClickCPS() {
        int _pressed = GLFW.glfwGetMouseButton(
                MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_MOUSE_BUTTON_1);

        boolean pressed = (_pressed == 1);

        if (pressed != this.wasPressed) {
            this.wasLastPressed = System.currentTimeMillis();
            this.wasPressed = pressed;
            if (pressed) {
                this.clicks.add(this.wasLastPressed);
            }
        }

        final long time = System.currentTimeMillis();
        this.clicks.removeIf(x -> x + 1000 < time);
        return this.clicks.size();
    }
}
