package com.mathlabs.graphs;

/**
 * The Sum class represents a collection of added Graph objects.
 *
 * @author michaelneu
 */
public class Sum extends Graph {
    protected final Graph[] elements;

    /**
     * Create a new sum with given elements.
     *
     * @param elements
     */
    public Sum(Graph... elements) {
        this.elements = new Graph[elements.length];

        for (int i = 0; i < this.elements.length; i++) {
            Graph g = elements[i];

            if (g == null) {
                throw new InvalidGraphError();
            } else {
                this.elements[i] = g;
            }
        }
    }

    @Override
    public double getY(double x) {
        double result = 0;

        for (Graph g : this.elements) {
            if (g != null) {
                result += g.getY(x);
            }
        }

        return result;
    }

    @Override
    public Derivable derivate() {
        Graph[] derivates = new Graph[this.elements.length];

        for (int i = 0; i < derivates.length; i++) {
            Graph g = this.elements[i];

            if (g != null) {
                derivates[i] = (Graph)this.elements[i].derivate();
            }
        }

        return new Sum(derivates);
    }

    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i < this.elements.length; i++) {
            Graph g = this.elements[i];

            if (g == null) {
                result += "0";
            } else {
                result += "(" + g.toString() + ")";
            }

            if (i < this.elements.length - 1) {
                result += " + ";
            }
        }

        return result;
    }
}
