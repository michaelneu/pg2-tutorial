package com.mathlabs;

import com.mathlabs.graphs.*;

public class Main {
	public static void main(String[] args) {
		Graph g = new Sum(new Exponential(2), new Polynomial(1, 0, 2, 0));

		System.out.println(g);
		System.out.println(g.derivate());
	}
}
