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

    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.buttons.clear();
        for (int i = 0; i < DEFAULT_BUTTONS.size(); i++) {
            final int temp = i;
            this.addButton(
                    new CustomGuiButton((this.width / 2) - 100, 50 + (25 * i), 200, 20,
                            new LiteralText(DEFAULT_BUTTONS.get(i).getName()
                                    + DEFAULT_BUTTONS.get(i).getState().getName()),
                            (ButtonWidget) -> {
                                DEFAULT_BUTTONS.get(temp).onCLick();
                            }));
        }
        super.render(matrices, mouseX, mouseY, delta);
    }


    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
