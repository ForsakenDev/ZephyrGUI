package co.zmc.gui.net;

import java.util.ArrayList;

import co.zmc.gui.Log;
import co.zmc.gui.rendering.Renderer;
import co.zmc.gui.renderobjects.RectangleObject;
import co.zmc.gui.renderobjects.RenderObject;
import co.zmc.gui.renderobjects.TextObject;

public class NetCommandHandler {

	public static void handleCommand(String command, String object, ArrayList<String> args) {
		RenderObject obj = Renderer.getRenderObject(object);
		
		if (obj != null) {
			if (command.equals("RS")) {
				if (args.get(0).equals("W")) {
					((RectangleObject)obj).setWidth(Integer.parseInt(args.get(1)));
				} else if (args.get(0).equals("H")) {
					((RectangleObject)obj).setHeight(Integer.parseInt(args.get(1)));
				}
			}
			
			if (command.equals("POS")) {
				if (args.get(0).equals("X")) {
					obj.setX(Integer.parseInt(args.get(1)));
				} else if (args.get(0).equals("Y")) {
					obj.setY(Integer.parseInt(args.get(1)));
				}
			}
			
			if (command.equals("TXT")) {
				((TextObject)obj).setText(args.get(0));
			}
			
			if (command.equals("COL")) {
				obj.setColour(Integer.parseInt(args.get(0)));
			}
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
			Log.info("Removing " + object);
			Renderer.removeRenderObject(object);
		}
		
		if (command.equals("CLR")) {
			Renderer.removeAllRenderObjects();
		}
	}
	
}
