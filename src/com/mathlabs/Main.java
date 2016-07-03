package com.mathlabs;

import com.mathlabs.link.*;
import com.mathlabs.lists.LinkedList;

public class Main {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();

		for (int i = 1; i <= 100; i++) {
			list.append(i);
		}

		list = list.parallel()
					.filter(new BooleanFunction<Integer>() {
						@Override
						public boolean matches(Integer data) {
							double value = MathLabs.sqrt(data.doubleValue());

							return MathLabs.abs(value - (int)value) < 0.00000001;
						}
					})
					.toList();

		System.out.print("Numbers whose square root is an integer: ");

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));

			if (i != list.size() - 1) {
				System.out.print(", ");
			}
		}
	}
}
