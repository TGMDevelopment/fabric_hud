package tech.lowspeccorgi.fabric_hud.elements.element;

import net.minecraft.client.MinecraftClient;
import tech.lowspeccorgi.fabric_hud.elements.Element;

public class pingElement extends Element {
    private final MinecraftClient CLIENT_OBJ = MinecraftClient.getInstance();

    public pingElement() {
        super(true, 0.0, 0.0);
        super.text = "Ping";
    }

    @Override
    public void updateElement() {
        super.text = "Ping: " + CLIENT_OBJ.player.networkHandler
                .getPlayerListEntry(CLIENT_OBJ.player.getUuid()).getLatency();
    }

    @Override
    public pingElement getInstanceOfElement() {
        return new pingElement();
    }


    @Override
    public String getDesc() {
        return "Shows your current Ping";
    }
}
