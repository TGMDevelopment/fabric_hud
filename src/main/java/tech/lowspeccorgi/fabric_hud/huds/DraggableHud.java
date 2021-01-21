package tech.lowspeccorgi.fabric_hud.huds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.google.common.collect.Lists;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.AbstractButtonWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import tech.lowspeccorgi.fabric_hud.elements.Element;
import tech.lowspeccorgi.fabric_hud.elements.ElementManager;
import tech.lowspeccorgi.fabric_hud.elements.category.CategoryRegister;
import tech.lowspeccorgi.fabric_hud.huds.elements.CustomGuiButton;
import tech.lowspeccorgi.fabric_hud.util.DrawHelper;
import java.awt.*;

public class DraggableHud extends Screen {
    private ElementManager elementManager;

    private final MinecraftClient CLIENT_OBJ = MinecraftClient.getInstance();
    private List<CustomGuiButton> buttonTrayButtons = Lists.newArrayList();
    private List<ArrayList<CustomGuiButton>> dropDownButtons =
            new ArrayList<ArrayList<CustomGuiButton>>();
    private Element captured;
    private boolean buttonTrayOpen = false;

    public DraggableHud(ElementManager elementManager) {
        super(new LiteralText("DraggableHud"));
        this.elementManager = elementManager;
    }

    @Override
    protected void init() {
        this.buttonTrayButtons.clear();
        this.dropDownButtons.clear();
        this.addButton(new CustomGuiButton((this.width / 2) - 50, this.height - 50, 100, 20,
                new LiteralText("Open button menu"), (ButtonWidget) -> {
                    buttonTrayOpen = !buttonTrayOpen;
                }));

        for (int i = 0; i < CategoryRegister.CATEGORIES.size(); i++) {
            final int temp = i;
            this.buttonTrayButtons
                    .add(new CustomGuiButton((this.width / CategoryRegister.CATEGORIES.size()) * i,
                            this.height - 120, this.width / CategoryRegister.CATEGORIES.size(), 20,
                            new LiteralText(CategoryRegister.CATEGORIES.get(i).getCategoryName()),
                            (ButtonWidget) -> {
                                CategoryRegister.CATEGORIES.get(temp).setVisible(
                                        !CategoryRegister.CATEGORIES.get(temp).getVisible());
                            }));

            this.dropDownButtons.add(new ArrayList<CustomGuiButton>());
            for (int j = 0; j < CategoryRegister.CATEGORIES.get(i).getELEMENTS().size(); j++) {
                this.dropDownButtons.get(i).add(j, new CustomGuiButton(
                        (this.width / CategoryRegister.CATEGORIES.size()) * i,
                        (this.height - 120) - ((j + 1) * 20),
                        this.width / CategoryRegister.CATEGORIES.size(), 20,
                        new LiteralText(
                                CategoryRegister.CATEGORIES.get(i).getELEMENTS().get(j).getText()),
                        (ButtonWidget) -> {
                            System.out.println("Test./");
                        }));
            }
        }
    }

    private void addButtonToTray(int i) {
        this.elementManager.addElement(
                CategoryRegister.CATEGORIES.get(i).getELEMENTS().get(i).getInstanceOfElement());
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        DrawHelper.drawSolidQuad(matrices, 0, 0, this.width, this.height,
                new Color(128, 128, 128, 50));
        List<Element> elements = elementManager.getElements();
        for (Element element : elements) {
            DrawHelper.drawSolidQuad(matrices, (int) element.getX(), (int) element.getY(),
                    ((int) element.getX() + textRenderer.getWidth(element.getText())),
                    (int) element.getY() + 10, new Color(135, 148, 158, 150));
        }
        if (this.buttonTrayOpen) {
            DrawHelper.drawSolidQuad(matrices, 0, this.height - 180, this.width, this.height - 60,
                    new Color(255, 255, 255, 100));

            for (int i = 0; i < this.buttonTrayButtons.size(); ++i) {
                ((AbstractButtonWidget) this.buttonTrayButtons.get(i)).render(matrices, mouseX,
                        mouseY, delta);
            }

            for (int i = 0; i < this.dropDownButtons.size(); i++) {
                for (int j = 0; j < this.dropDownButtons.get(i).size(); j++) {
                    ((AbstractButtonWidget) this.dropDownButtons.get(i).get(j)).render(matrices,
                            mouseX, mouseY, delta);
                }
            }
        }

        super.render(matrices, mouseX, mouseY, delta);

    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        for (int i = 0; i < CategoryRegister.CATEGORIES.size(); i++) {
            if (CategoryRegister.CATEGORIES.get(i).getVisible()) {
                for (int j = 0; j < CategoryRegister.CATEGORIES.get(i).getELEMENTS().size(); j++) {
                    this.dropDownButtons.get(i).get(j).mouseClicked(mouseX, mouseY, button);
                }
            }
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
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        captured = null;
        return true;
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
