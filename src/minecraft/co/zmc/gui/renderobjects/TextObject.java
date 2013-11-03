package co.zmc.gui.renderobjects;

import net.minecraft.client.Minecraft;

public class TextObject extends RenderObject{

	private String text;
	
	public TextObject(int xPos, int yPos, int colour, String text) {
		super(xPos, yPos, colour);
		
		this.text = text;
	}

	public TextObject() {
		super(0, 0, 0);
		this.text = "";
	}
	
	@Override
	public void render(Minecraft mc) {
		mc.fontRenderer.drawStringWithShadow(text, getX(), getY(), getColour());
	}

	public void setText(String text) {
		this.text = text;
	}
}
