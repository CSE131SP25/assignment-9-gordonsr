package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		//FIXME
		this.x = Math.random();
		this.y = Math.random(); 
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		//FIXME
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.filledCircle(x, y, FOOD_SIZE);
	}
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	
}
