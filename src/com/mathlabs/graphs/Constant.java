package com.mathlabs.graphs;

/**
 *
 * @author michaelneu
 */
public class Constant extends Graph {
    private final double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public double getY(double x) {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value + "";
    }
}
