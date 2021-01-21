package tech.lowspeccorgi.fabric_hud.huds.elements;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import tech.lowspeccorgi.fabric_hud.util.DrawHelper;
import java.awt.*;

public class CustomGuiButton extends ButtonWidget {
    private Text message;
    // Add an optional tooltip
    private CustomTooltip tooltip;
    private final MinecraftClient CLIENT = MinecraftClient.getInstance();

    public CustomGuiButton(int x, int y, int width, int height, Text message,
            ButtonWidget.PressAction onPress) {
        super(x, y, width, height, message, onPress, EMPTY);
        this.message = message;
    }

    public CustomGuiButton(int x, int y, int width, int height, Text message, String tooltip,
            ButtonWidget.PressAction onPress) {
        super(x, y, width, height, message, onPress, EMPTY);
        this.message = message;
        this.tooltip = new CustomTooltip(tooltip);
    }

    @Override
    public void renderButton(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        Color colour;
        if (this.hovered) {
            colour = new Color(111, 122, 130, 255);
        } else {
            colour = new Color(10, 10, 10, 255);
        }

        DrawHelper.drawSolidQuad(matrices, this.x, this.y, this.width + this.x,
                this.height + this.y, new Color(52, 52, 52, 255));
        DrawHelper.drawSolidQuad(matrices, this.x + 2, this.y + 2, (this.width - 2) + this.x,
                (this.height - 2) + this.y, colour);
        drawStringWithShadow(matrices, CLIENT.textRenderer, this.message.asString(), this.x + 5,
                this.y + this.height / 3, new Color(255, 255, 255, 255).getRGB());
    }

    public void tooltipRender(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        if (this.tooltip != null && this.hovered) {
            this.tooltip.render(matrices, mouseX, mouseY, delta);
        }
    }
}
