package tech.lowspeccorgi.fabric_hud.elements.element;

import java.util.ArrayList;
import java.util.List;
import org.lwjgl.glfw.GLFW;
import net.minecraft.client.MinecraftClient;
import tech.lowspeccorgi.fabric_hud.elements.Element;

public class cpsElement extends Element {
    private List<Long> leftClicks = new ArrayList<>();
    private List<Long> rightClicks = new ArrayList<>();
    private boolean leftWasPressed = false;
    private boolean rightWasPressed = false;
    private long leftWasLastPressed;
    private long rightWasLastPressed;

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
        int leftCps = getLeftClickCPS();
        int rightCps = getRightClickCPS();
        super.text = "CPS: " + leftCps + " : " + rightCps;
    }

    private int getLeftClickCPS() {
        int _pressed = GLFW.glfwGetMouseButton(
                MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_MOUSE_BUTTON_1);

        boolean pressed = (_pressed == 1);

        if (pressed != this.leftWasPressed) {
            this.leftWasLastPressed = System.currentTimeMillis();
            this.leftWasPressed = pressed;
            if (pressed) {
                this.leftClicks.add(this.leftWasLastPressed);
            }
        }

        final long time = System.currentTimeMillis();
        this.leftClicks.removeIf(x -> x + 1000 < time);
        return this.leftClicks.size();
    }

    private int getRightClickCPS() {
        int _pressed = GLFW.glfwGetMouseButton(
                MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_MOUSE_BUTTON_2);

        boolean pressed = (_pressed == 1);

        if (pressed != this.rightWasPressed) {
            this.rightWasLastPressed = System.currentTimeMillis();
            this.rightWasPressed = pressed;
            if (pressed) {
                this.rightClicks.add(this.rightWasLastPressed);
            }
        }

        final long time = System.currentTimeMillis();
        this.rightClicks.removeIf(x -> x + 1000 < time);
        return this.rightClicks.size();
    }
}
