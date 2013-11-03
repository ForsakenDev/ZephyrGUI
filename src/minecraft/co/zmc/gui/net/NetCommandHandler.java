package co.zmc.gui.net;

import java.util.ArrayList;

import co.zmc.gui.rendering.Renderer;
import co.zmc.gui.renderobjects.RectangleObject;
import co.zmc.gui.renderobjects.RenderObject;
import co.zmc.gui.renderobjects.TextObject;

public class NetCommandHandler {

	public static void handleCommand(String command, String object, ArrayList<String> args) {
		RenderObject obj = Renderer.getRenderObject(object);
		
		if (obj != null) {
			obj.handleCommand(command, args);
		}
		
		if (command.equals("ADD")) {
			if (args.get(0).equals("TXT")) {
				TextObject newObj = new TextObject();
				Renderer.addRenderObject(object, newObj);
			} else if (args.get(0).equals("RCT")) {
				RectangleObject newObj = new RectangleObject();
				Renderer.addRenderObject(object, newObj);
			}
		}
		
		if (command.equals("RM")) {
			Renderer.removeRenderObject(object);
		}
		
		if (command.equals("CLR")) {
			Renderer.removeAllRenderObjects();
		}
	}
	
}
