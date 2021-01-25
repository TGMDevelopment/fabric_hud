package tech.lowspeccorgi.fabric_hud.elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import tech.lowspeccorgi.fabric_hud.elements.element.biomeElement;
import tech.lowspeccorgi.fabric_hud.elements.element.cpsElement;
import tech.lowspeccorgi.fabric_hud.elements.element.fpsElement;
import tech.lowspeccorgi.fabric_hud.elements.element.memoryElement;
import tech.lowspeccorgi.fabric_hud.elements.element.pingElement;
import tech.lowspeccorgi.fabric_hud.elements.element.positionElement;

public class ElementRegistry {
    private static final List<Element> ELEMENTS = Arrays.asList(new cpsElement(), new fpsElement(),
            new pingElement(), new biomeElement(), new memoryElement(), new positionElement());

    public static List<Element> getELEMENTS() {
        return ELEMENTS;
    }
}
