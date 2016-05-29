package com.mathlabs.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * The BinaryEndNode class represents an end node in a binary search tree which completes the composite design pattern.
 *
 * @author michaelneu
 */
public class BinaryEndNode<T extends Comparable<T>> implements BinaryNode<T> {
    @Override
    public BinaryNode<T> insert(T data) {
        return new BinaryDataNode<>(data);
    }

    @Override
    public boolean contains(T data) {
        return false;
    }

    @Override
    public List<T> toList(TreeOutputOrder order) {
        return new ArrayList<>();
    }
}
