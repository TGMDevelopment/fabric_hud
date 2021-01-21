package tech.lowspeccorgi.fabric_hud.huds.elements;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import tech.lowspeccorgi.fabric_hud.util.DrawHelper;
import java.awt.*;

public class CustomTooltip {
    private String text;
    private final MinecraftClient CLIENT = MinecraftClient.getInstance();

    public CustomTooltip(String text) {
        this.text = text;
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        DrawHelper.drawSolidQuad(matrices, mouseX, mouseY,
                mouseX + CLIENT.textRenderer.getWidth(this.text), mouseY + 10,
                new Color(200, 200, 200, 255));
        CLIENT.textRenderer.draw(matrices, this.text, (float) mouseX, (float) mouseY,
                new Color(10, 10, 10, 255).getRGB());
    }
}
