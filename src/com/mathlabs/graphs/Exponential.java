package com.mathlabs.graphs;

/**
 * The Exponential class represents a Graph in the form of "base^exponent".
 *
 * @author michaelneu
 */
public class Exponential extends Graph {
    private final Graph exponent;
    private final double base;

    /**
     * Create a new exponential function with given base and exponent.
     *
     * @param base
     * @param exponent
     */
    public Exponential(double base, Graph exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    /**
     * Create a new exponential function with a given base, resulting in "base^x".
     * @param base
     */
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

    public Graph derivate() {
        return new Product(this, new Constant(Math.log(this.base) / Math.log(Math.E)), this.exponent.derivate());
    }

    @Override
    public String toString() {
        return this.base + "^(" + this.exponent.toString() + ")";
    }
}
