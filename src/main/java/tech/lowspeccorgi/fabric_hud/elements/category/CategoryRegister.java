package tech.lowspeccorgi.fabric_hud.elements.category;

import java.util.Arrays;
import java.util.List;
import tech.lowspeccorgi.fabric_hud.elements.Element;

public class CategoryRegister {
    public static final List<ElementCategory> CATEGORIES =
            Arrays.asList(new DebugCategory(), new TestCategory());
}
