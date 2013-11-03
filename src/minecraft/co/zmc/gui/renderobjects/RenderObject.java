package co.zmc.gui.renderobjects;

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
	
	public abstract void render(Minecraft mc);
}
