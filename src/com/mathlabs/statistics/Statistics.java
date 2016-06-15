package com.mathlabs.statistics;

import com.mathlabs.Fraction;
import com.mathlabs.IllegalDataInsertedError;
import com.mathlabs.MathLabs;
import com.mathlabs.graphs.Graph;
import com.mathlabs.graphs.Polynomial;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Statistics class provides methods used for statistical calculations.
 *
 * @author michaelneu
 */
public final class Statistics {
    /**
     * The Statistics.Event class describes a statistical event.
     */
    public static final class Event {
        private static int EVENT_ID = 0;

        private final int id;
        private final String description;

        /**
         * Creates a new Event with the given description and id.
         *
         * @param description
         * @param id
         */
        public Event(String description, int id) {
            this.description = description;
            this.id = id;

            Event.EVENT_ID = id + 1;
        }

        /**
         * Creates a new Event with the given description.
         *
         * @param description
         */
        public Event(String description) {
            this(description, Event.EVENT_ID);

            Event.EVENT_ID++;
        }

        public int getId() {
            return this.id;
        }

        public String getDescription() {
            return this.description;
        }

        @Override
        public int hashCode() {
            int result = 41;

            result = result * 37 + this.id;

            return result;
        }
    }

    /**
     * The Statistics.Measurement class describes the accumulated measurement of an event.
     */
    private final class Measurement {
        private final Event event;
        private int count;

        /**
         * Creates a new Measurement for the given event.
         *
         * @param event
         */
        public Measurement(Event event) {
            this.event = event;
            this.count = 1;
        }

        /**
         * Increments the measurement counter.
         */
        public void incrementCount() {
            this.count++;
        }

        public Event getEvent() {
            return this.event;
        }

        public int getCount() {
            return this.count;
        }
    }

    private List<Measurement> measurements;

    /**
     * Creates new statistics about the given events.
     *
     * @param events
     */
    public Statistics(Event... events) {
        Map<Event, Measurement> eventMeasurementMap = new HashMap<>();

        // group elements
        for (Event event : events) {
            if (event == null) {
                throw new IllegalDataInsertedError();
            } else {
                if (!eventMeasurementMap.containsKey(event)) {
                    eventMeasurementMap.put(event, new Measurement(event));
                }

                Measurement measurement = eventMeasurementMap.get(event);
                measurement.incrementCount();
            }
        }

        // sort the keys
        List<Event> eventList = new ArrayList<>(eventMeasurementMap.keySet());

        eventList.sort(new Comparator<Event>() {
            @Override
            public int compare(Event event1, Event event2) {
                return Integer.compare(event1.getId(), event2.getId());
            }
        });

        // then get the then sorted values
        this.measurements = new ArrayList<>();

        for (Event event : eventList) {
            this.measurements.add(eventMeasurementMap.get(event));
        }
    }

    /**
     * Calculates the linear regression through the event points.
     *
     * @return
     */
    public Graph getRegressionLine() {
        double[] x = new double[this.measurements.size()],
                y = new double[x.length];

        // calculate x_overline/y_overline
        for (int i = 0; i < this.measurements.size(); i++) {
            Measurement measurement = this.measurements.get(i);

            x[i] = measurement.getEvent().getId();
            y[i] = measurement.getCount();
        }

        double x_overline = MathLabs.arithmeticMiddle(x),
                y_overline = MathLabs.arithmeticMiddle(y);

        Fraction oneNth = new Fraction(1, x.length);

        // calculate S_x
        double temp = 0;

        for (double xi : x) {
            temp += MathLabs.pow(xi - x_overline, 2);
        }

        double S_x = MathLabs.sqrt(oneNth.toDouble() * temp);

        // calculate S_xy
        temp = 0;

        for (int i = 0; i < x.length; i++) {
            double xi = x[i],
                    yi = y[i];

            temp += (xi - x_overline) * (yi - y_overline);
        }

        double S_xy = oneNth.toDouble() * temp;

        // calculate f(x)
        double beta_hat = S_xy / MathLabs.pow(S_x, 2),
                alpha_hat = y_overline - beta_hat * x_overline;

        return new Polynomial(beta_hat, alpha_hat);
    }
}
