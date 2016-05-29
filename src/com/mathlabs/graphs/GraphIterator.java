package com.mathlabs.graphs;

import java.util.Iterator;

/**
 * The GraphIterator class allows iterating over a given Derivable implementing object.
 *
 * @author michaelneu
 */
public class GraphIterator implements Iterator<Derivable> {
    private Derivable derivable;

    /**
     * Create a new GraphIterator with a given Derivable.
     *
     * @param derivable
     */
    public GraphIterator(Derivable derivable) {
        this.derivable = derivable;
    }

    @Override
    public boolean hasNext() {
        return this.derivable.canBeDerived();
    }

    @Override
    public Derivable next() {
        this.derivable = this.derivable.derivate();

        return this.derivable;
    }
}
