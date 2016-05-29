package com.mathlabs;

import com.mathlabs.graphs.*;

public class Main {
	public static void main(String[] args) {
		Graph g = new Polynomial(1, 0, 2, 0);
		System.out.println(g);

		for (Derivable derivate : g) {
			System.out.println(derivate);
		}
	}
}
