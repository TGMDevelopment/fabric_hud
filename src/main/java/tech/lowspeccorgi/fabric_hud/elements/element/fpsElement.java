package tech.lowspeccorgi.fabric_hud.elements.element;

import tech.lowspeccorgi.fabric_hud.elements.Element;

public class fpsElement extends Element {

    public fpsElement() {
        super(true, 0.0, 0.0);
        super.text = "FPS";
    }

    @Override
    public cpsElement getInstanceOfElement() {
        return new cpsElement();
    }

    @Override
    public String getDesc() {
        return "Shows your current FPS";
    }
}
