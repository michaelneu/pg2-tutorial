package com.mathlabs;

import com.mathlabs.trees.BinarySearchTree;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		int upperBoundary = 15;

		for (int i = 0; i < 20; i++) {
			tree.insert(rand.nextInt(upperBoundary));
		}

		System.out.println(tree);

		for (int i = 0; i < upperBoundary; i++) {
			if (!tree.contains(i)) {
				System.out.printf("%d: false\n", i);
			}
		}
	}
}
