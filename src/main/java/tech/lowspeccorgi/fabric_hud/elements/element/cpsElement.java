package tech.lowspeccorgi.fabric_hud.elements.element;

import tech.lowspeccorgi.fabric_hud.elements.Element;

public class cpsElement extends Element {

    public cpsElement() {
        super(true, 0.0, 0.0);
        super.text = "CPS";
    }

    @Override
    public fpsElement getInstanceOfElement() {
        return new fpsElement();
    }

    @Override
    public String getDesc() {
        return "Shows your current CPS";
    }
}
