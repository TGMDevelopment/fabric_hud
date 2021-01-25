package tech.lowspeccorgi.fabric_hud.elements;

public class State {
    String name;
    Object state;

    public State(String name, Object state) {
        this.name = name;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public Object getState() {
        return state;
    }
}
