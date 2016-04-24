package com.mathlabs.graphs;

/**
 * The class Point represents a point in the two-dimensional cartesian coordinate system. 
 * 
 * @author michaelneu
 */
public class Point {
	private double x, y;
	
	/**
	 * Creates a new point at the origin of the coordinate system. 
	 */
	public Point() {
		this(0, 0);
	}
	
	/**
	 * Creates a new point at (x;y). 
	 * 
	 * @param x
	 * @param y
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	@Override
	public String toString() {
		return "(" + this.x + "; " + this.y + ")";
	}
}
