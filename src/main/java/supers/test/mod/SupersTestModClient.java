package supers.test.mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class SupersTestModClient implements ClientModInitializer{

    private static KeyBinding alignRotation = KeyBindingHelper.registerKeyBinding(new KeyBinding(
       "key.superstestmod.align_rotation",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_F7,
            "category.superstestmod.superstestmod"
    ));

    @Override
    public void onInitializeClient() {

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (alignRotation.wasPressed()) {
                client.player.setYaw((float) (Math.floor(client.player.getYaw() / 90) * 90));
            }
        });
        EntityRendererRegistry.register(SupersTestMod.DYNAMITE_ENTITY_TYPE, FlyingItemEntityRenderer::new);

    }
    
}
