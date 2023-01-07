package org.example.linkedlists;
import java.util.Arrays;

public class SumListInOrder {

    public static SinglyLinkedNode<Integer> addSum(SinglyLinkedNode<Integer> l1, SinglyLinkedNode<Integer> l2) {

        var length1 = length(l1);
        var length2 = length(l2);

        if (length1 > length2) {
            l2 = padWithZeros(l2, length1 - length2);
        } else if (length2 > length1) {
            l1 = padWithZeros(l1, length2 - length1);
        }

        var partial = new PartialSum();

        addSum(l1, l2, partial);
        if (partial.carry > 0) {
            var node = new SinglyLinkedNode<>(partial.carry);
            node.setNext(partial.head);
            partial.head = node;
        }

        return partial.head;
    }

    private static SinglyLinkedNode<Integer> padWithZeros(SinglyLinkedNode<Integer> node, int num) {
        var integers = new Integer[num];
        Arrays.fill(integers, 0);
        var zeros = SinglyLinkedNode.buildLinkedList(integers);
        
        var tail = getTail(zeros);
        tail.setNext(node);
        return zeros;
    }

    private static SinglyLinkedNode<Integer> getTail(SinglyLinkedNode<Integer> node) {
        while (node.hasNext()) {
            node = node.getNext();
        }
        return node;
    }

    private static int length(SinglyLinkedNode<Integer> node) {
        var len = 1;
        while (node.hasNext()) {
            len++;
            node = node.getNext();
        }
        return len;
    }

    private static void addSum(SinglyLinkedNode<Integer> l1, SinglyLinkedNode<Integer> l2, PartialSum partial) {
        if (l1.hasNext()) {
            addSum(l1.getNext(), l2.getNext(), partial);
        }

        partial.addElements(l1, l2);
    }

    static class PartialSum {

        public int carry;
        public SinglyLinkedNode<Integer> head;

        void addElements(SinglyLinkedNode<Integer> node1, SinglyLinkedNode<Integer> node2) {
            var sum = node1.getElement() + node2.getElement() + carry;
            if (sum > 9) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            var node = new SinglyLinkedNode<>(sum);

            node.setNext(head);
            head = node;
        }
    }

}
