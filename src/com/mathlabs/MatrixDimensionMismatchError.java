package com.mathlabs;

/**
 * The MatrixDimensionMismatchException is used to describe a size mismatch when misusing matrices in arithmetic operations.
 *
 * @author michaelneu
 */
public final class MatrixDimensionMismatchError extends Error {
    private final Matrix left, right;

    /**
     * Creates a new exception with the two affected matrices.
     *
     * @param left
     * @param right
     */
    public MatrixDimensionMismatchError(Matrix left, Matrix right) {
        this.left = left;
        this.right = right;
    }

    public Matrix getLeft() {
        return this.left;
    }

    public Matrix getRight() {
        return this.right;
    }
}
