package com.mathlabs;

import com.mathlabs.lists.DoubleLinkedList;
import com.mathlabs.lists.LinkedList;

public class Main {
	private static void testList(LinkedList<Integer> list) {
		for (int i = 0; i < 10; i++) {
			list.append(i);
		}

		System.out.print("\tappended [0-9]:         ");

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));

			if (i < list.size() - 1) {
				System.out.print(", ");
			}
		}

		list.remove(4);
		list.remove(5);

		System.out.print("\n\tremoved 4 and 5:        ");

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));

			if (i < list.size() - 1) {
				System.out.print(", ");
			}
		}

		list.insert(4, 3);
		System.out.print("\n\tinserted 4 at index 3:  ");

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));

			if (i < list.size() - 1) {
				System.out.print(", ");
			}
		}

		System.out.println("\n");
	}

	public static void main(String[] args) {
		System.out.println("Testing single linked list");
		Main.testList(new LinkedList<>());

		System.out.println("Testing double linked list");
		Main.testList(new DoubleLinkedList<>());
	}
}
