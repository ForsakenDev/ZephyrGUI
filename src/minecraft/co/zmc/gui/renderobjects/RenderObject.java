package co.zmc.gui.renderobjects;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;

public abstract class RenderObject {

	private int xPos;
	private int yPos;
	private int colour;
	
	public RenderObject(int xPos, int yPos, int colour) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.colour = colour;
	}
	
	public int getX() {
		return xPos;
	}
	
	public int getY() {
		return yPos;
	}
	
	public void setX(int xPos) {
		this.xPos = xPos;
	}
	
	public void setY(int yPos) {
		this.yPos = yPos;
	}

	public int getColour() {
		return colour;
	}
	
	public void setColour(int colour) {
		this.colour = colour;
	}
	
	public void handleCommand(String command, ArrayList<String> args) {
		if (command.equals("POS")) {
			if (args.get(0).equals("X")) {
				setX(Integer.parseInt(args.get(1)));
			} else if (args.get(0).equals("Y")) {
				setY(Integer.parseInt(args.get(1)));
			}
		}
		
		if (command.equals("COL")) {
			setColour(Integer.parseInt(args.get(0)));
		}
	}
	
	public abstract void render(Minecraft mc);
}
