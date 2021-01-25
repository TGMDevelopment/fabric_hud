package tech.lowspeccorgi.fabric_hud.elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Widget {
    private String name;
    private WidgetModes.Modes mode;
    private List<State> states = new ArrayList<State>();
    private State state;
    private int statePointer = 0;

    public Widget(String name, WidgetModes.Modes mode) {
        this.name = name;
        this.mode = mode;
        this.states = Arrays.asList(new State("ON", true), new State("OFF", false));
        this.state = this.states.get(0);
    }

    public Widget(String name, WidgetModes.Modes mode, List<State> states) {
        this.name = name;
        this.mode = mode;
        this.states = states;
        this.state = this.states.get(0);
    }

    public void onCLick() {
        if (statePointer == this.states.size() - 1) {
            this.statePointer = 0;
            this.state = this.states.get(statePointer);
        } else {
            this.statePointer++;
            this.state = this.states.get(statePointer);
        }
    }

    public WidgetModes.Modes getMode() {
        return mode;
    }

    public String getName() {
        return name;
    }

    public List<State> getStates() {
        return states;
    }

    public State getState() {
        return this.state;
    }
}
