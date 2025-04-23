package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	
	private Snake newSnake;
	private Food newFood;
	private int score;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		
		this.newSnake = new Snake();
		this.newFood = new Food();
		this.score = 0;
		
		//FIXME - construct new Snake and Food objects
	}
	
	public void play() {
		while (newSnake.isInbounds()) { //TODO: Update this condition to check if snake is in bounds
			int dir = getKeypress();
			if(dir != -1) {
				newSnake.changeDirection(dir);
			}
			//Testing only: you will eventually need to do more work here
			//System.out.println("Keypress: " + dir);
			//newSnake.changeDirection(dir);
			
			/*
			 * 1. Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */
			this.newSnake.move();
			
			
			if(newSnake.eatFood(newFood)) {
				score++;
				newFood = new Food(); //creates new food 
			}
			updateDrawing();
		}
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		//FIXME
		
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
		StdDraw.clear();
		StdDraw.text(0.1, 0.95, "Score" + score);
		this.newSnake.draw();
		this.newFood.draw();
		StdDraw.pause(50);
		StdDraw.show();
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
