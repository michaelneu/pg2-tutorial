package com.mathlabs.lists;

/**
 * The EndNode represents an ending node in a linked list.
 *
 * @author michaelneu
 */
public class EndNode<T> implements LinkedNode<T> {
    @Override
    public LinkedNode<T> insert(T data, int index) {
        return new DataNode<>(data);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public LinkedNode<T> getNext() {
        return this;
    }

    @Override
    public void setNext(LinkedNode<T> next) { }

    @Override
    public T getData() {
        return null;
    }
}
