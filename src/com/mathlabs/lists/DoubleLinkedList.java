package com.mathlabs.lists;

/**
 * The DoubleLinkedList class provides a double linked list.
 *
 * @author michaelneu
 */
public class DoubleLinkedList<T> extends LinkedList<T> {
    /**
     * Creates a new double linked list.
     */
    public DoubleLinkedList() {
        this.root = new DoubleLinkedEndNode<>();
    }

    @Override
    public void remove(T data) {
        if (this.size() == 0) {
            return;
        }

        if (this.root.getData().equals(data)) {
            this.root = this.root.getNext();
        } else {
            DoubleLinkedNode<T> temp = (DoubleLinkedNode<T>)root;

            while (!(temp instanceof DoubleLinkedEndNode)) {
                if (temp.getData().equals(data)) {
                    DoubleLinkedNode<T> next = (DoubleLinkedNode<T>)temp.getNext();

                    next.setPrevious(temp.getPrevious());

                    temp.getPrevious()
                        .setNext(next);

                    break;
                } else {
                    temp = (DoubleLinkedNode<T>)temp.getNext();
                }
            }
        }
    }
}
