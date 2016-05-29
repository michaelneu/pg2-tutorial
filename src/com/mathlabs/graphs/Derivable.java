package com.mathlabs.graphs;

import java.util.Iterator;

/**
 * Implementing this interface allows an object to be derived and used in a foreach-loop.
 *
 * @author michaelneu
 */
public interface Derivable extends Iterable<Derivable> {
    /**
     * Creates the derivative of the graph.
     *
     * @return
     */
    Derivable derivate();

    /**
     * Returns whether the current graph can be derived.
     *
     * @return
     */
    default boolean canBeDerived() {
        return true;
    }

    @Override
    default Iterator<Derivable> iterator() {
        return new GraphIterator(this);
    }
}
