package tech.lowspeccorgi.fabric_hud.huds;

import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import tech.lowspeccorgi.fabric_hud.elements.Widget;
import tech.lowspeccorgi.fabric_hud.huds.elements.CustomGuiButton;

public class SettingsHud extends Screen {
    private List<Widget> DEFAULT_BUTTONS;
    private final MinecraftClient CLIENT_OBJ = MinecraftClient.getInstance();

    public SettingsHud(Text title, List<Widget> DEFAULT_BUTTONS) {
        super(title);
        this.DEFAULT_BUTTONS = DEFAULT_BUTTONS;
    }

    @Override
    protected void init() {
        super.init();
        for (int i = 0; i < DEFAULT_BUTTONS.size(); i++) {
            this.addButton(new CustomGuiButton((this.width / 2) - 50, 50 + (25 * i), 75, 20,
                    new LiteralText(DEFAULT_BUTTONS.get(i).getName()), (ButtonWidget) -> {

                    }));
        }
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {

        super.render(matrices, mouseX, mouseY, delta);
    }


    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
