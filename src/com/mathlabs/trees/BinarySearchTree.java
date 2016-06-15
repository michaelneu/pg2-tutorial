package com.mathlabs.trees;

import com.mathlabs.IllegalDataInsertedError;

import java.util.Arrays;
import java.util.List;

/**
 * The BinarySearchTree class provides an unbalanced, searchable, binary tree.
 *
 * @author michaelneu
 */
public class BinarySearchTree<T extends Comparable<T>> {
    private BinaryNode<T> root;

    /**
     * Creates a new binary search tree.
     */
    public BinarySearchTree() {
        this.root = new BinaryEndNode<>();
    }

    /**
     * Inserts the given data into the tree.
     *
     * @param data
     */
    public void insert(T data) {
        if (data == null) {
            throw new IllegalDataInsertedError();
        } else {
            this.root = root.insert(data);
        }
    }

    /**
     * Returns whether the tree contains the given data.
     *
     * @param data
     * @return
     */
    public boolean contains(T data) {
        return this.root.contains(data);
    }

    /**
     * Converts the tree to a String, ordered by the given order.
     *
     * @param order
     * @return
     */
    public String toString(TreeOutputOrder order) {
        List<T> list = this.root.toList(order);

        return Arrays.toString(list.toArray());
    }

    @Override
    public String toString() {
        return this.toString(TreeOutputOrder.INORDER);
    }

    /**
     * Converts the tree to a list, ordered by the given order.
     *
     * @param order
     * @return
     */
    public List<T> toList(TreeOutputOrder order) {
        return this.root.toList(order);
    }
}
