package tech.lowspeccorgi.fabric_hud.elements.category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import tech.lowspeccorgi.fabric_hud.elements.Element;
import tech.lowspeccorgi.fabric_hud.elements.element.cpsElement;
import tech.lowspeccorgi.fabric_hud.elements.element.fpsElement;

public class ElementCategory {
    protected String categoryName = "Element Category";
    protected static List<Element> ELEMENTS;
    protected boolean visible = false;

    public ElementCategory() {
        // Here you add stuff to your category
    }

    public String getCategoryName() {
        return categoryName;
    }

    public static List<Element> getELEMENTS() {
        return ELEMENTS;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public static void setELEMENTS(List<Element> eLEMENTS) {
        ELEMENTS = eLEMENTS;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
