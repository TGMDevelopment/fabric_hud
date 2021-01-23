package tech.lowspeccorgi.fabric_hud.huds;

import java.util.List;
import com.google.common.collect.Lists;
import org.lwjgl.glfw.GLFW;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.AbstractButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import tech.lowspeccorgi.fabric_hud.elements.Element;
import tech.lowspeccorgi.fabric_hud.elements.ElementManager;
import tech.lowspeccorgi.fabric_hud.elements.ElementRegistry;
import tech.lowspeccorgi.fabric_hud.huds.elements.CustomGuiButton;
import tech.lowspeccorgi.fabric_hud.util.DrawHelper;
import java.awt.*;

public class DraggableHud extends Screen {


    private ElementManager elementManager;

    private final MinecraftClient CLIENT_OBJ = MinecraftClient.getInstance();
    private List<CustomGuiButton> buttonTrayButtons = Lists.newArrayList();
    private List<CustomGuiButton> settingButtons = Lists.newArrayList();
    private Element captured;
    private boolean buttonTrayOpen = false;

    public DraggableHud(ElementManager elementManager) {
        super(new LiteralText("DraggableHud"));
        this.elementManager = elementManager;
    }

    @Override
    protected void init() {
        this.buttonTrayButtons.clear();

        this.addButton(new CustomGuiButton((this.width / 2) - 50, this.height - 70, 100, 20,
                new LiteralText("Open button menu"), (ButtonWidget) -> {
                    buttonTrayOpen = !buttonTrayOpen;
                }));

        List<Element> elements = ElementRegistry.getELEMENTS();
        for (int i = 0; i < elements.size(); i++) {
            final int temp = i;
            this.buttonTrayButtons.add(new CustomGuiButton(
                    ((this.width / elements.size()) * i) - ((i == 0) ? 0 : 1), this.height - 47,
                    this.width / elements.size(), 20, new LiteralText(elements.get(i).getText()),
                    elements.get(i).getDesc(), (ButtonWidget) -> {
                        elementManager.addElement(elements.get(temp).getInstanceOfElement());
                    }));
        }

    }


    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        List<Element> elements = elementManager.getElements();
        this.settingButtons.clear();
        for (Element element : elements) {
            DrawHelper.drawSolidQuad(matrices, (int) element.getX(), (int) element.getY(),
                    ((int) element.getX() + textRenderer.getWidth(element.getText())),
                    (int) element.getY() + 10, new Color(135, 148, 158, 150));

            this.settingButtons.add(new CustomGuiButton((int) element.getX() - 17,
                    (int) element.getY() - 19, 17, 19, new LiteralText("⚙"), (ButtonWidget) -> {
                        CLIENT_OBJ.openScreen(new SettingsHud(new LiteralText("settings"),
                                element.getDEFAULT_BUTTONS()));
                    }));
        }

        for (int i = 0; i < this.settingButtons.size(); i++) {
            ((AbstractButtonWidget) this.settingButtons.get(i)).render(matrices, mouseX, mouseY,
                    delta);
        }

        if (this.buttonTrayOpen) {
            for (int i = 0; i < this.buttonTrayButtons.size(); i++) {
                ((AbstractButtonWidget) this.buttonTrayButtons.get(i)).render(matrices, mouseX,
                        mouseY, delta);
            }
            for (int i = 0; i < this.buttonTrayButtons.size(); i++) {
                this.buttonTrayButtons.get(i).tooltipRender(matrices, mouseX, mouseY, delta);
            }
        }

        super.render(matrices, mouseX, mouseY, delta);

    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (this.buttonTrayOpen) {
            for (int i = 0; i < this.buttonTrayButtons.size(); i++) {
                this.buttonTrayButtons.get(i).mouseClicked(mouseX, mouseY, button);
            }
        }

        for (int i = 0; i < this.settingButtons.size(); i++) {
            this.settingButtons.get(i).mouseClicked(mouseX, mouseY, button);
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX,
            double deltaY) {
        List<Element> elements = elementManager.getElements();

        if (button == GLFW.GLFW_MOUSE_BUTTON_1) {
            if (captured == null) {
                for (Element element : elements) {
                    int textWidth = CLIENT_OBJ.textRenderer.getWidth(element.getText());
                    if (mouseX >= element.getX() && mouseX <= textWidth + element.getX()
                            && mouseY >= element.getY() && mouseY <= 10 + element.getY()) {
                        captured = element;
                        break;
                    }
                }
            } else {
                captured.setX(captured.getX() + deltaX);
                captured.setY(captured.getY() + deltaY);
            }
        }
        return true;
    }

    @Override
    public void renderBackground(MatrixStack matrices) {
        super.renderBackground(matrices);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        captured = null;
        return true;
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
