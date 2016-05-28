package com.mathlabs;

import com.mathlabs.graphs.*;
import com.mathlabs.drawing.*;

public class Main {
	public static void main(String[] args) {
		Canvas canvas = new Canvas(300, 300, new Point(-20, 20), new Point(10, -10));

		canvas.setBackground("white");

		Graph g = new Graph();

		canvas.draw(g, "black");
	}
}
