package com.mathlabs.trees;

import java.util.List;

/**
 * Implementing this interface allows an object to be used inside a binary tree.
 *
 * @author michaelneu
 */
public interface BinaryNode<T extends Comparable<T>> {
    /**
     * Inserts the given data into the tree.
     *
     * @param data
     */
    BinaryNode<T> insert(T data);

    /**
     * Returns whether the tree contains the given data.
     *
     * @param data
     * @return
     */
    boolean contains(T data);

    /**
     * Converts the tree to a list, ordered by the given order.
     *
     * @param order
     * @return
     */
    List<T> toList(TreeOutputOrder order);
}
