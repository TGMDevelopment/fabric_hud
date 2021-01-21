package tech.lowspeccorgi.fabric_hud.elements;

public class Element {
    protected boolean visible;
    protected String text = "Element Template";
    protected double x;
    protected double y;

    /**
     * Constructs a Element
     *
     * @author Basilicous
     * @param visible Whether the Element is actually visible or not
     */
    public Element(boolean visible, double x, double y) {
        this.visible = visible;
        this.x = x;
        this.y = y;
    }

    public Element getInstanceOfElement() {
        return new Element(true, 0.0, 0.0);
    }

    /**
     * Get's the description of the Element
     * 
     * @author Basilicous
     * @return The description of the Element
     */
    public String getDesc() {
        return "Element template";
    }

    /**
     * Gets the X position of the Element
     *
     * @author Basilicous
     * @return The X position of the Element
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the Y position of the Element
     *
     * @author Basilicous
     * @return The Y position of the Element
     */
    public double getY() {
        return y;
    }

    /**
     * Gets the visibility of the Element
     *
     * @author Basilicous
     * @return The visiblity of the Element
     */
    public boolean getVisible() {
        return visible;
    }

    /**
     * Gets the Element's text
     *
     * @author Basilicous
     * @return The Element's text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the visibilty of the Element
     *
     * @author Basilicous
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * Sets the Element's text
     *
     * @author Basilicous
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Sets the X position of the Element
     *
     * @author Basilicous
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Sets the Y position of the Element
     *
     * @author Basilicous
     */
    public void setY(double y) {
        this.y = y;
    }
}
