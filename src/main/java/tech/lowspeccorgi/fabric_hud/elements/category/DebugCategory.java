package tech.lowspeccorgi.fabric_hud.elements.category;

import java.util.Arrays;
import tech.lowspeccorgi.fabric_hud.elements.ElementManager;
import tech.lowspeccorgi.fabric_hud.elements.element.cpsElement;
import tech.lowspeccorgi.fabric_hud.elements.element.fpsElement;
import tech.lowspeccorgi.fabric_hud.elements.Element;

// Cointains things you may see in the f3 screen
public class DebugCategory extends ElementCategory {
    public DebugCategory() {
        // Here you add stuff to your category
        this.categoryName = "Debug Category";
        ELEMENTS = Arrays.asList(new fpsElement(), new cpsElement());
    }
}
