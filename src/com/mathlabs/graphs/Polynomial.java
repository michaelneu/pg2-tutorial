package com.mathlabs.graphs;

import com.mathlabs.MathLabs;

/**
 * The Polynomial class represents a Graph in the form of "a * x^2 + b * x^1 + c * x^0".
 *
 * @author michaelneu
 */
public class Polynomial extends Graph {
    private final double[] coefficients;

    /**
     * Create a new polynomial function with given coefficients.
     *
     * @param coefficients
     */
    public Polynomial(double... coefficients) {
        this.coefficients = new double[coefficients.length];

        System.arraycopy(coefficients, 0, this.coefficients, 0, coefficients.length);
    }

    @Override
    public double getY(double x) {
        double result = 0;

        for (int i = 0; i < this.coefficients.length; i++) {
            double coefficient = this.coefficients[i];

            result += coefficient * MathLabs.pow(x, this.coefficients.length - i - 1);
        }

        return result;
    }

    @Override
    public Derivable derivate() {
        int length = this.coefficients.length;

        if (length == 1) {
            return new Constant(0);
        } else if (length == 2) {
            return new Constant(this.coefficients[0]);
        } else {
            double[] derivatedCoefficients = new double[length - 1];

            for (int i = 0; i < derivatedCoefficients.length; i++) {
                int exponent = derivatedCoefficients.length - i + 1;

                derivatedCoefficients[i] = exponent * this.coefficients[i];
            }

            return new Polynomial(derivatedCoefficients);
        }
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
