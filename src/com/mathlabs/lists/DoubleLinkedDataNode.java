package com.mathlabs.lists;

/**
 * The DoubleLinkedDataNode class represents a double linked list node containing data.
 *
 * @author michaelneu
 */
public class DoubleLinkedDataNode<T> implements DoubleLinkedNode<T> {
    private DoubleLinkedNode<T> previous, next;
    private T data;

    /**
     * Creates a new data node.
     *
     * @param data
     */
    public DoubleLinkedDataNode(T data) {
        this.data = data;

        DoubleLinkedNode<T> node = new DoubleLinkedEndNode<>();
        node.setPrevious(this);
        this.setNext(node);

        this.setPrevious(new DoubleLinkedEndNode<>());
    }

    @Override
    public DoubleLinkedNode<T> getPrevious() {
        return this.previous;
    }

    @Override
    public void setPrevious(DoubleLinkedNode<T> prev) {
        this.previous = prev;
    }

    @Override
    public LinkedNode<T> insert(T data, int index) {
        if (index == 0) {
            DoubleLinkedNode<T> node = new DoubleLinkedDataNode<>(data);
            node.setNext(this.getNext());

            this.setNext(node);
        } else {
            this.setNext(this.next.insert(data, index - 1));
        }

        DoubleLinkedNode<T> next = (DoubleLinkedNode<T>)this.getNext();
        next.setPrevious(this);

        return this;
    }

    @Override
    public int size() {
        return 1 + this.getNext().size();
    }

    @Override
    public LinkedNode<T> getNext() {
        return this.next;
    }

    @Override
    public void setNext(LinkedNode<T> next) {
        this.next = (DoubleLinkedNode<T>)next;
    }

    @Override
    public T getData() {
        return this.data;
    }
}
