package supers.test.mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class SupersTestModClient implements ClientModInitializer{

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(SupersTestMod.DYNAMITE_ENTITY_TYPE, FlyingItemEntityRenderer::new);
    }
    
}
