package com.mathlabs.lists;

/**
 * Represents a double linked node in a linked list.
 *
 * @author michaelneu
 */
public interface DoubleLinkedNode<T> extends LinkedNode<T> {
    DoubleLinkedNode<T> getPrevious();
    void setPrevious(DoubleLinkedNode<T> prev);
}
