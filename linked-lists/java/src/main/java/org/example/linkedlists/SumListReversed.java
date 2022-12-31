package org.example.linkedlists;

import java.text.MessageFormat;

public class SumListReversed {
    public static SinglyLinkedNode<Integer> addSum(SinglyLinkedNode<Integer> l1, SinglyLinkedNode<Integer> l2) {
        return new SinglyLinkedNode<>(l1.getElement() + l2.getElement());
    }

}
