package org.example.linkedlists;

public class SinglyLinkedNode<T> implements Node<T> {
    private final T element;
    private SinglyLinkedNode<T> next;

    public SinglyLinkedNode(T element) {
        this.element = element;
    }

    @SafeVarargs
    public static <E> SinglyLinkedNode<E> buildLinkedList(E ...elements) {
        var firstNode = new SinglyLinkedNode<>(elements[0]);

        var node = firstNode;
        boolean first = true;
        for (E e : elements) {
            if (first) {
                first = false;
                continue;
            }
            node.setNext(new SinglyLinkedNode<>(e));
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

    public SinglyLinkedNode<T> getNext() {
        return next;
    }

    public void setNext(SinglyLinkedNode<T> node) {
        this.next = node;
    }

    @Override
    public String toString() {
        return "SinglyLinkedNode{" +
                "ref=" + System.identityHashCode(this) +
                ", element=" + element +
                ", hasNext=" + hasNext() +
                '}';
    }
}
