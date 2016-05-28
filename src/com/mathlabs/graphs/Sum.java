package com.mathlabs.graphs;

/**
 *
 * @author michaelneu
 */
public class Sum extends Graph {
    private final Graph[] elements;

    public Sum(Graph... elements) {
        this.elements = new Graph[elements.length];

        System.arraycopy(elements, 0, this.elements, 0, elements.length);
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
