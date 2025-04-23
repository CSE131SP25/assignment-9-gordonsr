package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		//FIXME - set up the segments instance variable
		deltaX = 0;
		deltaY = 0;
		segments = new LinkedList<BodySegment>();
		BodySegment initialSegment = new BodySegment(0.5, 0.5, SEGMENT_SIZE);  // Starting at (0.5, 0.5)
        segments.add(initialSegment); 
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		//FIXME
		BodySegment head = segments.getFirst();  // Get the head (first segment in the list)
		double newHeadX = head.getX() + deltaX;  
	    double newHeadY = head.getY() + deltaY; 
        
	    for(int i = segments.size() - 1; i > 0; i--) { 
	    	BodySegment current = segments.get(i);
	    	BodySegment previous = segments.get(i-1);
	    	current.setX(previous.getX());
	    	current.setY(previous.getY());
	    
	    }
	    //	head.setX(newHeadX);
	    //	head.setY(newHeadY);
	    
	    	segments.getFirst().setX(newHeadX);
	    	segments.getFirst().setY(newHeadY);
	
	    
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for (BodySegment segments : segments) {
			segments.draw(); 
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		//FIXME
		BodySegment head = segments.getFirst();
		double distance = Math.sqrt(Math.pow(f.getX() - head.getX(), 2) + (Math.pow(f.getY() - head.getY(), 2)));
		
		if(distance < SEGMENT_SIZE + Food.FOOD_SIZE) {
			BodySegment tail = segments.getLast();
			BodySegment newSegment = new BodySegment (tail.getX(), tail.getY(), SEGMENT_SIZE);
			segments.add(newSegment);
			return true;
		}
		return false; //food is not eaten
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		//FIXME
		BodySegment head = segments.getFirst();
		if(head.getX() < 0 || head.getX() > 1) {
			return false;
		}else if (head.getY() < 0 || head.getY() > 1) {
			return false;
		}
		return true; 

	}
}
