package tech.lowspeccorgi.fabric_hud.elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import tech.lowspeccorgi.fabric_hud.elements.element.cpsElement;
import tech.lowspeccorgi.fabric_hud.elements.element.fpsElement;

public class ElementRegistry {
    private static final List<Element> ELEMENTS = Arrays.asList(new cpsElement(), new fpsElement());

    public static List<Element> getELEMENTS() {
        return ELEMENTS;
    }
}
