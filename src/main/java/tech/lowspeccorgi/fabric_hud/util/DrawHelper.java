package tech.lowspeccorgi.fabric_hud.util;

import javax.swing.plaf.ColorUIResource;
import com.mojang.blaze3d.systems.RenderSystem;
import org.apache.commons.lang3.tuple.Pair;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Matrix4f;
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
