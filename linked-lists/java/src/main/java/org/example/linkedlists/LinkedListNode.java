package org.example.linkedlists;

public class LinkedListNode<T> implements Node<T> {
    private final T element;
    private LinkedListNode<T> next;
    private LinkedListNode<T> previous;

    public LinkedListNode(T element) {
        this.element = element;
    }

    @SafeVarargs
    public static <E> LinkedListNode<E> buildLinkedList(E... elements) {
        var firstNode = new LinkedListNode<>(elements[0]);

        var node = firstNode;
        boolean first = true;
        for (E e : elements) {
            if (first) {
                first = false;
                continue;
            }
            node.setNext(new LinkedListNode<>(e));
            node.getNext().setPrevious(node);
            node = node.getNext();
        }

        return firstNode;
    }

    public boolean hasNext() {
        return next != null;
    }

    public T getElement() {
        return element;
    }

    public LinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<T> node) {
        this.next = node;
    }

    public LinkedListNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(LinkedListNode<T> node) {
        this.previous = node;
    }
}
