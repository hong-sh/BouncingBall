package Model;

import java.awt.Color;

public class Oval {

	private Color ovalColor;
	private int ovalX;
	private int ovalY;
	private int ovalWidth;
	private int ovalHeight;
	
	public Oval(Color ovalColor, int ovalX, int ovalY, int ovalWidth, int ovalHeight) {
		this.ovalColor = ovalColor;
		this.ovalX = ovalX;
		this.ovalY = ovalY;
		this.ovalWidth = ovalWidth;
		this.ovalHeight = ovalHeight;
	}

	public Color getOvalColor() {
		return ovalColor;
	}

	public int getOvalX() {
		return ovalX;
	}

	public int getOvalY() {
		return ovalY;
	}

	public int getOvalWidth() {
		return ovalWidth;
	}

	public int getOvalHeight() {
		return ovalHeight;
	}
	
	
}
