package co.zmc.gui.rendering;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;

public class RenderEvent {
	
	private Minecraft mc;
	
	public RenderEvent(Minecraft mc) {
		this.mc = mc;
	}
	
	@ForgeSubscribe(priority = EventPriority.NORMAL)
    public void eventHandler(RenderGameOverlayEvent event) {
		if (event.type == ElementType.TEXT) {
			Renderer.renderAllObjects(mc);
		}
	}
	
}
