package com.mathlabs.lists;

/**
 * The DataNode class represents a list node containing data.
 *
 * @author michaelneu
 */
public class DataNode<T> implements LinkedNode<T> {
    private LinkedNode<T> next;
    private T data;

    /**
     * Creates a new data node.
     *
     * @param data
     */
    public DataNode(T data) {
        this.next = new EndNode<>();
        this.data = data;
    }

    @Override
    public LinkedNode<T> insert(T data, int index) {
        if (index == 0) {
            LinkedNode<T> node = new DataNode<>(data);
            node.setNext(this.getNext());

            this.setNext(node);
        } else {
            this.next = this.next.insert(data, index - 1);
        }

        return this;
    }

    @Override
    public int size() {
        return 1 + this.next.size();
    }

    @Override
    public LinkedNode<T> getNext() {
        return this.next;
    }

    @Override
    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }

    @Override
    public T getData() {
        return this.data;
    }
}
