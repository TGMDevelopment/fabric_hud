package tech.lowspeccorgi.fabric_hud.elements;

import java.awt.*;

public class Colour {
    public enum Colours {
        RED, GREEN, BLUE, BLACK,
    }


    public static Color getColours(Colours colours) {
        switch (colours) {
            case RED:
                return new Color(255, 0, 0);
            case GREEN:
                return new Color(0, 255, 0);
            case BLUE:
                return new Color(0, 0, 255);
            case BLACK:
                return new Color(0, 0, 0);
            default:
                throw new RuntimeException(
                        "Not a vaid colour! Infact, you should get a syntax error from this so I'm not sure how the fuck you managed to get this, congrats if you managed to fuck things up this badly, so the Java compiler doesn't work properly!");
        }
    }
}
