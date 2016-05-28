package com.mathlabs.graphs;

import com.mathlabs.MathLabs;

/**
 *
 * @author michaelneu
 */
public class Polynomial extends Graph {
    private final double[] coefficients;

    public Polynomial(double... coefficients) {
        this.coefficients = new double[coefficients.length];

        System.arraycopy(coefficients, 0, this.coefficients, 0, coefficients.length);
    }

    @Override
    public double getY(double x) {
        double result = 0;

        for (int i = 0; i < this.coefficients.length; i++) {
            result += MathLabs.pow(x, this.coefficients.length - i - 1);
        }

        return result;
    }

    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i < this.coefficients.length; i++) {
            result += this.coefficients[i] + " * x^" + (this.coefficients.length - i - 1);

            if (i < this.coefficients.length - 1) {
                result += " + ";
            }
        }

        return result;
    }
}
