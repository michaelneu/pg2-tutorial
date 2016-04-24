package com.mathlabs.graphs;

import com.mathlabs.MathLabs;

/**
 * The class Graph represents a graph in the cartesian coordinate system, providing a method to get the y-value of any x-value. 
 * 
 * @author michaelneu
 */
public class Graph {
	/**
	 * Gets the y-value of any given point on the abscissa. 
	 * 
	 * @param x
	 * @return
	 */
	public double getY(double x) {
		return x;
	}
	
	/**
	 * Gets all points on the graph in [start:end] with a distance of stepSize between each point. 
	 * 
	 * @param start Start of the interval
	 * @param end End of the interval
	 * @param stepSize Size of each step between two points
	 * @return
	 */
	public Point[] toPoints(double start, double end, double stepSize) {
		int size = (int)MathLabs.abs((end - start) / stepSize) + 1;
		
		Point[] points = new Point[size];
		
		for (int i = 0; i < size; i++) {
			double x = start + i * stepSize;
			
			points[i] = new Point(x, getY(x));
		}
		
		return points;
	}
}
