package co.zmc.gui.rendering;

import java.util.HashMap;
import java.util.Map.Entry;

import co.zmc.gui.renderobjects.RenderObject;

import net.minecraft.client.Minecraft;

public class Renderer {

	private static HashMap<String, RenderObject> objects = new HashMap<String, RenderObject>();
	
	public static void addRenderObject(String id, RenderObject object) {
		if (objects.containsKey(id)) {
			System.out.println("Render object " + id + " is being replaced");
			objects.remove(id);
		}
		
		objects.put(id, object);
	}
	
	public static void removeRenderObject(String id) {
		objects.remove(id);
	}
	
	public static void removeAllRenderObjects() {
		objects.clear();
	}
	
	public static void renderAllObjects(Minecraft mc) {
		for (Entry<String, RenderObject> obj : objects.entrySet()) {
			obj.getValue().render(mc);
		}
	}
	
	public static RenderObject getRenderObject(String id) {
		if (objects.containsKey(id)) {
			return objects.get(id);
		}
		return null;
	}
}