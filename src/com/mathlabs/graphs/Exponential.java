package com.mathlabs.graphs;

/**
 *
 * @author michaelneu
 */
public class Exponential extends Graph {
    private final Graph exponent;
    private final double base;

    public Exponential(double base, Graph exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    public Exponential(double base) {
        this.base = base;
        this.exponent = new Polynomial(1, 0);
    }

    @Override
    public double getY(double x) {
        if (this.exponent != null) {
            return Math.pow(this.base, this.exponent.getY(x));
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return this.base + "^(" + this.exponent.toString() + ")";
    }
}
