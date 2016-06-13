package com.mathlabs.lists;

/**
 * Represents a single linked node in a linked list.
 *
 * @author michaelneu
 */
public interface LinkedNode<T> {
    /**
     * Inserts the given data into a linked list.
     *
     * @param data
     * @param index
     * @return The next list node
     */
    LinkedNode<T> insert(T data, int index);

    /**
     * Gets the size of the list at this node.
     *
     * @return
     */
    int size();

    LinkedNode<T> getNext();
    void setNext(LinkedNode<T> next);
    T getData();
}
