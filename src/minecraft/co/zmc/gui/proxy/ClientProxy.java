package co.zmc.gui.proxy;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import co.zmc.gui.rendering.RenderEvent;
import co.zmc.gui.rendering.Renderer;
import co.zmc.gui.renderobjects.RectangleObject;

public class ClientProxy extends Proxy {

	@Override
	public void registerRenderers() {
		MinecraftForge.EVENT_BUS.register(new RenderEvent(Minecraft.getMinecraft()));
	}
	
}
