package com.mathlabs;

import com.mathlabs.graphs.Graph;
import com.mathlabs.statistics.Statistics;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Statistics.Event event1 = new Statistics.Event("a"),
				event2 = new Statistics.Event("b"),
				event3 = new Statistics.Event("c"),
				event4 = new Statistics.Event("d"),
				event5 = new Statistics.Event("e"),
				event6 = new Statistics.Event("f");

		Random rand = new Random();

		// generate 25 to 50 events
		Statistics.Event[] events = new Statistics.Event[rand.nextInt(25) + 25];

		for (int i = 0; i < events.length; i++) {
			switch (rand.nextInt(6)) {
				case 0:
					events[i] = event1;
					break;

				case 1:
					events[i] = event2;
					break;

				case 2:
					events[i] = event3;
					break;

				case 3:
					events[i] = event4;
					break;

				case 4:
					events[i] = event5;
					break;

				default:
					events[i] = event6;
					break;
			}
		}

		// get some statistical information about the collected data
		Statistics statistics = new Statistics(events);
		Graph regression = statistics.getRegressionLine();

		System.out.println(regression);
	}
}
