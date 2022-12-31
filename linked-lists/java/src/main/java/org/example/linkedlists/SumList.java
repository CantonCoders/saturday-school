package org.example.linkedlists;

public class SumList {
    public static SinglyLinkedNode<Integer> reverseOrderSum(SinglyLinkedNode<Integer> list1, SinglyLinkedNode<Integer> list2) {
        return new SinglyLinkedNode(list1.getElement() + list2.getElement());
    }
}
