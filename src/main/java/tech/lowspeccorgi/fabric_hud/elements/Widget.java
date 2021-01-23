package tech.lowspeccorgi.fabric_hud.elements;

import java.util.Arrays;
import java.util.List;

public class Widget {
    private String name;
    private WidgetModes.Modes mode;
    private List<String> states;

    public Widget(String name, WidgetModes.Modes mode) {
        this.name = name;
        this.mode = mode;
        this.states = Arrays.asList("ON", "OFF");
    }

    public Widget(String name, WidgetModes.Modes mode, List<String> states) {
        this.name = name;
        this.mode = mode;
        this.states = states;
    }

    public WidgetModes.Modes getMode() {
        return mode;
    }

    public String getName() {
        return name;
    }

    public List<String> getStates() {
        return states;
    }
}
