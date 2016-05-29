package com.mathlabs.graphs;

/**
 * The Constant class represents a constant value in the cartesian coordinate system.
 *
 * @author michaelneu
 */
public class Constant extends Graph {
    private final double value;

    /**
     * Create a new constant.
     *
     * @param value
     */
    public Constant(double value) {
        this.value = value;
    }

    @Override
    public double getY(double x) {
        return this.value;
    }

    @Override
    public Derivable derivate() {
        return new Constant(0);
    }

    @Override
    public boolean canBeDerived() {
        return false;
    }

    @Override
    public String toString() {
        return this.value + "";
    }
}
