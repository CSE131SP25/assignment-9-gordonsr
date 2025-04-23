package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {

	private double x, y, size;
	private Color color;
	
	public BodySegment(double x, double y, double size) {
		//FIXME
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = ColorUtils.solidColor();
		//See ColorUtils for some color options (or choose your own)
	}
	
	/**
	 * Draws the segment
	 */
	public void draw() {
		//FIXME
		StdDraw.setPenColor(this.color);
		StdDraw.filledCircle(this.x, this.y, this.size);
	}
	
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public void setX(double newX) {
		this.x = newX;
	}
	public void setY(double newY) {
		this.y = newY;
		
	}
}
