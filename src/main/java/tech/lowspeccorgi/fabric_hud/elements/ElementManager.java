package tech.lowspeccorgi.fabric_hud.elements;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;
import tech.lowspeccorgi.fabric_hud.util.DrawHelper;

public class ElementManager {
    private static List<Element> ELEMENTS = new ArrayList<Element>();
    private final MinecraftClient CLIENT_OBJ = MinecraftClient.getInstance();

    /**
     * Constructs the ElementManager class
     * 
     * @author Basilicous
     * @param elements The elements you want to construct the ElementManager with
     */
    public ElementManager(Element... elements) {
        for (Element element : elements) {
            ELEMENTS.add(element);
        }

        HudRenderCallback.EVENT.register((matrixstack, __) -> {
            for (int i = 0; i < this.ELEMENTS.size(); i++) {
                if ((boolean) ELEMENTS.get(i).getDEFAULT_BUTTONS().get(1).getState()
                        .getState() == true) {
                    DrawHelper
                            .drawSolidQuad(matrixstack, (int) ELEMENTS.get(i).getX() - 3,
                                    (int) ELEMENTS.get(i).getY() - 3,
                                    (int) ELEMENTS.get(i).getX() + CLIENT_OBJ.textRenderer
                                            .getWidth(ELEMENTS.get(i).getText()) + 11,
                                    (int) ELEMENTS.get(i)
                                            .getY() + 11,
                                    new Color(10, 10, 10,
                                            (((boolean) ELEMENTS.get(i).getDEFAULT_BUTTONS().get(2)
                                                    .getState().getState() == true) ? 200 : 255)));
                }

                // This is ugly, but eh:
                // Correction: This is all ugly, never let me do ui code again
                if ((boolean) ELEMENTS.get(i).getDEFAULT_BUTTONS().get(3).getState()
                        .getState() == true) {
                    CLIENT_OBJ.textRenderer.drawWithShadow(matrixstack,
                            new LiteralText(ELEMENTS.get(i).getText()).asOrderedText(),
                            (float) ELEMENTS.get(i).getX(), (float) ELEMENTS.get(i).getY(), Colour
                                    .getColours((Colour.Colours) ELEMENTS.get(i)
                                            .getDEFAULT_BUTTONS().get(0).getState().getState())
                                    .getRGB());
                } else {
                    CLIENT_OBJ.textRenderer.draw(matrixstack,
                            new LiteralText(ELEMENTS.get(i).getText()).asOrderedText(),
                            (float) ELEMENTS.get(i).getX(), (float) ELEMENTS.get(i).getY(), Colour
                                    .getColours((Colour.Colours) ELEMENTS.get(i)
                                            .getDEFAULT_BUTTONS().get(0).getState().getState())
                                    .getRGB());
                }
                ELEMENTS.get(i).updateElement();
            }

        });

    }

    /**
     * Adds an element to the ElementManager
     * 
     * @author Basilicous
     * @param element The element you want to add
     */
    public void addElement(Element element) {
        ELEMENTS.add(element);
    }

    /**
     * Gets an element from the ElementManager
     * 
     * @author Basilicous
     * @param index The index from which you want to fetch the element from
     * @return Returns the element located at the index you passed in
     */
    public Element getElement(int index) {
        return ELEMENTS.get(index);
    }

    /**
     * Gets the Element list
     * 
     * @author Basilicous
     * @return Returns the Element list which you've fetched
     */
    public List<Element> getElements() {
        return ELEMENTS;
    }
}
