package com.mathlabs.link;

/**
 * The BooleanFunctionExecutor class provides methods to run a BooleanFunction in a background thread.
 *
 * @author michaelneu
 */
public class BooleanFunctionExecutor<T> implements Runnable {
    private final BooleanFunction<T> predicate;
    private final T data;

    private boolean result = false;

    /**
     * Creates a new BooleanFunctionExecutor with a given predicate and data to apply to the predicate.
     */
    public BooleanFunctionExecutor(BooleanFunction<T> predicate, T data) {
        this.predicate = predicate;
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public boolean getResult() {
        return this.result;
    }

    @Override
    public void run() {
        this.result = this.predicate.matches(this.data);
    }
}
