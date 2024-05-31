package utility;

import java.lang.Math;

/**
 * A class for a Point object in 2D space
 * 
 * @author jaime
 *
 */
public class Point2D {

	private int x; // x position
	private int y; // y position

	/**
	 * No-argument constructor for a point, initial position: (0, 0)
	 */
	public Point2D() {
		x = 0;
		y = 0;
	}

	/**
	 * Constructor for a point with position (x, y)
	 * 
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Getter method for the X coordinate of this point
	 * 
	 * @return the X coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Getter method for the Y coordinate of this point
	 * 
	 * @return the Y coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * Setter method for the X coordinate of this point
	 * 
	 * @param x the new x coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Setter method for the Y coordinate of this point
	 * 
	 * @param y the new y coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Calculates the distance between two points using euclidean distance
	 * 
	 * @param other the other point
	 * @return the distance between the two points
	 */
	public double getDistance(Point2D other) {
		return Math.abs(Math.sqrt(Math.pow((x - other.getX()), 2) + Math.pow((y - other.getY()), 2)));
	}

	/**
	 * Calculates the angle between two points
	 * 
	 * @param other the other point
	 * @return the angle between the two points
	 */
	public double getAngle(Point2D other) {
		double dx = Math.abs(x - other.getX());
		double dy = Math.abs(y - other.getY());
		if (dx == 0) {
			return -1;
		}
		return Math.abs(Math.toDegrees(Math.atan(dy / dx)));
	}
}