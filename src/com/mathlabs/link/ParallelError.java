package com.mathlabs.link;

/**
 * The ParallelError is used to describe an exception thrown when using list.parallel().
 *
 * @author michaelneu
 */
public class ParallelError extends Error {
    private final Throwable error;

    /**
     * Creates a new ParallelError with the thrown exception.
     */
    public ParallelError(Throwable error) {
        this.error = error;
    }

    public Throwable getError() {
        return this.error;
    }
}
