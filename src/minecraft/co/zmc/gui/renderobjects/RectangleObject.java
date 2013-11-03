package co.zmc.gui.renderobjects;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;

public class RectangleObject extends RenderObject {

	private int width;
	private int height;
	
	public RectangleObject(int xPos, int yPos, int colour, int width, int height) {
		super(xPos, yPos, colour);
		
		this.width = width;
		this.height = height;
	}
	
	public RectangleObject() {
		super(0, 0, 0);
		this.width = 0;
		this.height = 0;
	}

	@Override
	public void render(Minecraft mc) {
		GuiIngame.drawRect(getX(), getY(), getX() + width, getY() + height, getColour());
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}

}
