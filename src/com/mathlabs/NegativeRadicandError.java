package com.mathlabs;

/**
 * The NegativeRadicandError is used to describe the error when trying to calculate the square root of a negative number.
 *
 * @author michaelneu
 */
public final class NegativeRadicandError extends Error {
    private final double number;

    public NegativeRadicandError(double number) {
        this.number = number;
    }

    public double getNumber() {
        return this.number;
    }
}
