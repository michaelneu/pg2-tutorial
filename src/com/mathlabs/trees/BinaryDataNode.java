package com.mathlabs.trees;

import java.util.List;
import java.util.ArrayList;

/**
 * The BinaryDataNode class represents a data node in a binary search tree.
 *
 * @author michaelneu
 */
public class BinaryDataNode<T extends Comparable<T>> implements BinaryNode<T> {
    private final T data;
    private BinaryNode<T> childLeft, childRight;

    /**
     * Creates a new node with the given data.
     *
     * @param data
     */
    public BinaryDataNode(T data) {
        this.data = data;

        this.childLeft = new BinaryEndNode<>();
        this.childRight = new BinaryEndNode<>();
    }

    @Override
    public BinaryNode<T> insert(T data) {
        if (this.data != null && this.data.compareTo(data) <= 0) {
            // put data bigger or equal than current data into right subtree
            this.childRight = this.childRight.insert(data);
        } else {
            // put smaller data into left subtree
            this.childLeft = this.childLeft.insert(data);
        }

        return this;
    }

    @Override
    public boolean contains(T data) {
        if (this.data != null) {
            if (this.data.compareTo(data) == 0) {
                return true;
            } else {
                return this.childLeft.contains(data) || this.childRight.contains(data);
            }
        } else if (data == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<T> toList(TreeOutputOrder order) {
        List<T> list = new ArrayList<>(),
                left = this.childLeft.toList(order),
                right = this.childRight.toList(order);

        switch (order) {
            case PREORDER:
                list.add(this.data);
                list.addAll(left);
                list.addAll(right);
                break;

            case POSTORDER:
                list.addAll(left);
                list.addAll(right);
                list.add(this.data);
                break;

            default:
                list.addAll(left);
                list.add(this.data);
                list.addAll(right);
                break;
        }

        return list;
    }
}
