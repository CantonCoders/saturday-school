package org.example.linkedlists;

public class SumListInOrder {

    public static SinglyLinkedNode<Integer> addSum(SinglyLinkedNode<Integer> l1, SinglyLinkedNode<Integer> l2) {
        return new SinglyLinkedNode<>(l1.getElement() + l2.getElement());
    }

}
