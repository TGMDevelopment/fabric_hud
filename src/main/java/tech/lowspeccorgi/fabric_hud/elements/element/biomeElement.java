package tech.lowspeccorgi.fabric_hud.elements.element;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.registry.Registry;
import tech.lowspeccorgi.fabric_hud.elements.Element;

public class biomeElement extends Element {
    private final MinecraftClient CLIENT_OBJ = MinecraftClient.getInstance();

    public biomeElement() {
        super(true, 0.0, 0.0);
        super.text = "Biome";
    }

    @Override
    public biomeElement getInstanceOfElement() {
        return new biomeElement();
    }

    @Override
    public void updateElement() {
        super.text = "Biome: " + CLIENT_OBJ.world.getRegistryManager().get(Registry.BIOME_KEY)
                .getId(CLIENT_OBJ.world.getBiome(CLIENT_OBJ.player.getBlockPos()));
    }

    @Override
    public String getDesc() {
        return "Shows the biome you're currently in";
    }
}

