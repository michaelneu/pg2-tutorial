package com.mathlabs.lists;

/**
 * The DoubleLinkedEndNode represents an ending node in a double linked list.
 *
 * @author michaelneu
 */
public class DoubleLinkedEndNode<T> implements DoubleLinkedNode<T> {
    @Override
    public DoubleLinkedNode<T> getPrevious() {
        return this;
    }

    @Override
    public void setPrevious(DoubleLinkedNode<T> prev) { }

    @Override
    public LinkedNode<T> insert(T data, int index) {
        DoubleLinkedNode<T> node = new DoubleLinkedDataNode<>(data);
        node.setPrevious(this.getPrevious());

        return node;
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
