package tech.lowspeccorgi.fabric_hud.elements;

import java.util.ArrayList;
import java.util.List;
import javax.swing.plaf.ColorUIResource;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;

public class ElementManager {
    private static List<Element> ELEMENTS = new ArrayList<Element>();

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
            for (Element element : ELEMENTS) {
                MinecraftClient.getInstance().textRenderer.draw(matrixstack,
                        new LiteralText(element.getText()).asOrderedText(), (float) element.getX(),
                        (float) element.getY(), new ColorUIResource(255, 34, 53).getRGB());
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
