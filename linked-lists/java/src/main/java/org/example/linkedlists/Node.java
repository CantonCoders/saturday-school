package org.example.linkedlists;

public interface Node<T> {
    T getElement();

    boolean hasNext();

    Node<T> getNext();

}
