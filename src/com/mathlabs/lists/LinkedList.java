package com.mathlabs.lists;

import com.mathlabs.IllegalDataInsertedError;
import com.mathlabs.link.Parallel;

/**
 * The LinkedList class provides a single linked list.
 *
 * @author michaelneu
 */
public class LinkedList<T> {
    protected LinkedNode<T> root;

    /**
     * Creates a new single linked list.
     */
    public LinkedList() {
        this.root = new EndNode<>();
    }

    /**
     * Inserts the given data at the end of the index.
     *
     * @param data
     */
    public void append(T data) {
        this.insert(data, this.size());
    }

    /**
     * Inserts the given data at the given index into the list.
     *
     * @param data
     * @param index
     */
    public void insert(T data, int index) {
        if (data == null) {
            throw new IllegalDataInsertedError();
        } else {
            this.root = this.root.insert(data, index);
        }
    }

    /**
     * Gets the list's data at the given index.
     *
     * @param index
     * @return
     */
    public T get(int index) {
        LinkedNode<T> node = this.root;

        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        return node.getData();
    }

    /**
     * Removes the given data from the list.
     *
     * @param data
     */
    public void remove(T data) {
        if (this.size() == 0) {
            return;
        }

        if (this.root.getData().equals(data)) {
            this.root = this.root.getNext();
        } else {
            LinkedNode<T> temp = root;

            while (!(temp instanceof EndNode)) {
                LinkedNode<T> next = temp.getNext();

                if (next.getData().equals(data)) {
                    temp.setNext(next.getNext());

                    break;
                } else {
                    temp = temp.getNext();
                }
            }
        }
    }

    /**
     * Gets the size of the list.
     *
     * @return
     */
    public int size() {
        return this.root.size();
    }

    /**
     * Gets a parallel stream to modify the list.
     */
    public Parallel<T> parallel() {
        return new Parallel<>(this);
    }
}
