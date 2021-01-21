package tech.lowspeccorgi.fabric_hud.util;

import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import java.awt.*;

public class DrawHelper {
        public static void drawSolidQuad(MatrixStack matrices, int x0, int y0, int x1, int y1,
                        Color colour) {
                DrawableHelper.fill(matrices, x0, y0, x1, y1, colour.getRGB());
        }

        public static int[] getSizeOfString(String string) {
                //
                int width = string.length() * 6;
                int height = 10;

                return new int[] {width, height};
        }
}
