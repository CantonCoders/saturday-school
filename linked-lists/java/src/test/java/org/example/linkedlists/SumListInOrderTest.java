package org.example.linkedlists;

import org.junit.jupiter.api.Test;

import static org.example.linkedlists.LinkedListAssert.validateWithRange;

public class SumListInOrderTest {


    @Test
    public void returnSingleDigitOnesPosition() {
        var list1 = SinglyLinkedNode.buildLinkedList(3);
        var list2 = SinglyLinkedNode.buildLinkedList(5);
        var sum = SumListInOrder.addSum(list1, list2);
        validateWithRange(sum, 8);
    }

    @Test
    public void returnSingleDigitAtTensPosition() {
        var list1 = SinglyLinkedNode.buildLinkedList(2, 7);
        var list2 = SinglyLinkedNode.buildLinkedList(4, 1);
        var sum = SumListInOrder.addSum(list1, list2);
        validateWithRange(sum, 6, 8);
    }

    @Test
    public void returnCoverOverAtHundredsPosition() {
        var list1 = SinglyLinkedNode.buildLinkedList(3, 1, 2);
        var list2 = SinglyLinkedNode.buildLinkedList(3, 6, 7);
        var sum = SumListInOrder.addSum(list1, list2);
        validateWithRange(sum, 6, 7, 9);
    }

    @Test
    public void returnCoverOverAtUnequalListLength() {
        //   0 312
        // + 8,367
        var list1 = SinglyLinkedNode.buildLinkedList(3, 1, 2);
        var list2 = SinglyLinkedNode.buildLinkedList(8, 3, 6, 7);
        var sum = SumListInOrder.addSum(list1, list2);
        validateWithRange(sum, 8, 6, 7, 9);
    }

    @Test
    public void returnCoverOverAtUnequalListLengthSwitched() {
        var list1 = SinglyLinkedNode.buildLinkedList(9, 8, 4, 6);
        var list2 = SinglyLinkedNode.buildLinkedList(5, 1, 2);
        var sum = SumListInOrder.addSum(list1, list2);
        validateWithRange(sum, 1, 0, 3, 5, 8);
    }

    @Test
    public void returnCoverOverAtUnequalListLengthByTwo() {
        // 9,846
        // 0 097
        var list1 = SinglyLinkedNode.buildLinkedList(9, 8, 4, 6);
        var list2 = SinglyLinkedNode.buildLinkedList(9, 7);
        var sum = SumListInOrder.addSum(list1, list2);
        validateWithRange(sum, 9, 9, 4, 3);
    }
}
