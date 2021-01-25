package tech.lowspeccorgi.fabric_hud.elements.element;

import net.minecraft.client.MinecraftClient;
import tech.lowspeccorgi.fabric_hud.elements.Element;

/*
 * All the credit goes to MatthewTGM for this element, much of the code for this specific element
 * was taken from here:
 * https://github.com/TGMDevelopment/SimpleHUD-Forge/blob/main/src/main/java/ga/matthewtgm/simplehud
 * /elements/impl/ElementMemory.java
 */
public class memoryElement extends Element {
    private final MinecraftClient CLIENT_OBJ = MinecraftClient.getInstance();

    public memoryElement() {
        super(true, 0.0, 0.0);
        super.text = "Memory";
    }

    @Override
    public void updateElement() {
        super.text = "Mem usage: "
                + this.bytesToMb(
                        Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())
                + '/' + this.bytesToMb(Runtime.getRuntime().maxMemory()) + "MB";
    }

    private long bytesToMb(long bytes) {
        return bytes / 1024L / 1024L;
    }

    @Override
    public memoryElement getInstanceOfElement() {
        return new memoryElement();
    }


    @Override
    public String getDesc() {
        return "Shows your current memory usage";
    }
}
