package com.mathlabs.link;

import com.mathlabs.lists.LinkedList;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The Parallel class provides methods to modify a given LinkedList in a parallel manner.
 *
 * @author michaelneu
 */
public class Parallel<T> {
    private LinkedList<T> list;

    /**
     * Creates a new Parallel with the given list.
     */
    public Parallel(LinkedList<T> list) {
        if (list == null) {
            throw new NullPointerException();
        } else {
            this.list = list;
        }
    }

    /**
     * Applies the given predicate to the list.
     */
    public Parallel<T> filter(BooleanFunction<T> predicate) {
        if (predicate == null) {
            throw new NullPointerException();
        } else {
            Map<Thread, BooleanFunctionExecutor<T>> map = new LinkedHashMap<>();

            for (int i = 0; i < this.list.size(); i++) {
                T data = this.list.get(i);
                BooleanFunctionExecutor<T> executor = new BooleanFunctionExecutor<>(predicate, data);

                Thread thread = new Thread(executor);
                thread.start();

                map.put(thread, executor);
            }

            LinkedList<T> filtered = new LinkedList<>();

            for (Map.Entry<Thread, BooleanFunctionExecutor<T>> entry : map.entrySet()) {
                Thread thread = entry.getKey();
                BooleanFunctionExecutor<T> executor = entry.getValue();

                try {
                    thread.join();
                } catch (InterruptedException e) {
                    throw new ParallelError(e);
                }

                if (executor.getResult()) {
                    filtered.append(executor.getData());
                }
            }

            this.list = filtered;

            return this;
        }
    }

    /**
     * Returns the modified list.
     */
    public LinkedList<T> toList() {
        return this.list;
    }
}
