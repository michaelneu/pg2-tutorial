package com.mathlabs.graphs;

/**
 * The Product class represents a collection of multiplied Graph objects.
 *
 * @author michaelneu
 */
public class Product extends Sum {
    /**
     * Create a new product with given elements.
     *
     * @param elements
     */
    public Product(Graph... elements) {
        super(elements);
    }

    @Override
    public double getY(double x) {
        double result = 1;

        for (Graph g : this.elements) {
            if (g != null) {
                result *= g.getY(x);
            }
        }

        return result;
    }

    @Override
    public Graph derivate() {
        Graph[] derivates = new Graph[this.elements.length];

        for (int i = 0; i < derivates.length; i++) {
            Graph f_i = this.elements[i];

            if (f_i != null) {
                Graph[] products = new Graph[derivates.length];
                products[0] = f_i.derivate();

                int productIndex = 1;

                for (int elementsIndex = 0; elementsIndex < this.elements.length; elementsIndex++) {
                    Graph f_k = this.elements[elementsIndex];

                    if (elementsIndex != i) {
                        products[productIndex] = f_k;
                        productIndex++;
                    }
                }

                derivates[i] = new Product(products);
            }
        }

        return new Product(derivates);
    }

    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i < this.elements.length; i++) {
            Graph g = this.elements[i];

            if (g == null) {
                result += "1";
            } else {
                result += "(" + g.toString() + ")";
            }

            if (i < this.elements.length - 1) {
                result += " * ";
            }
        }

        return result;
    }
}
