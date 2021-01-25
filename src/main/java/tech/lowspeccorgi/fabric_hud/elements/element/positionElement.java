package tech.lowspeccorgi.fabric_hud.elements.element;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;
import tech.lowspeccorgi.fabric_hud.elements.Element;

public class positionElement extends Element {
    private final MinecraftClient CLIENT_OBJ = MinecraftClient.getInstance();

    public positionElement() {
        super(true, 0.0, 0.0);
        super.text = "Position";
    }

    @Override
    public void updateElement() {
        BlockPos position = CLIENT_OBJ.player.getBlockPos();
        super.text =
                "X: " + position.getX() + " / Y: " + position.getY() + " / Z: " + position.getZ();
    }

    @Override
    public positionElement getInstanceOfElement() {
        return new positionElement();
    }


    @Override
    public String getDesc() {
        return "Shows the player's current position";
    }
}
