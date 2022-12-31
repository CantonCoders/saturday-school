package org.example.linkedlists;

import org.junit.jupiter.api.Test;

import static org.example.linkedlists.LinkedListAssert.validateWithRange;

public class SumListReversedTest {

    @Test
    public void returnSingleDigitOnesPosition() {
        var list1 = SinglyLinkedNode.buildLinkedList(3);
        var list2 = SinglyLinkedNode.buildLinkedList(5);
        var sum = SumListReversed.addSum(list1, list2);
        validateWithRange(sum, 8);
    }

    @Test
    public void returnSingleDigitAtTensPosition() {
        var list1 = SinglyLinkedNode.buildLinkedList(7, 2);
        var list2 = SinglyLinkedNode.buildLinkedList(1, 4);
        var sum = SumListReversed.addSum(list1, list2);
        validateWithRange(sum, 8, 6);
    }

    @Test
    public void returnCoverOverAtHundredsPosition() {
        var list1 = SinglyLinkedNode.buildLinkedList(2, 1, 3);
        var list2 = SinglyLinkedNode.buildLinkedList(7, 6, 3);
        var sum = SumListReversed.addSum(list1, list2);
        validateWithRange(sum, 9, 7, 6);
    }

    @Test
    public void returnCoverOverAtUnequalListLength() {
        var list1 = SinglyLinkedNode.buildLinkedList(2, 1, 3);
        var list2 = SinglyLinkedNode.buildLinkedList(7, 6, 3, 8);
        var sum = SumListReversed.addSum(list1, list2);
        validateWithRange(sum, 9, 7, 6, 8);
    }

    @Test
    public void returnCoverOverAtUnequalListLengthSwitched() {
        var list1 = SinglyLinkedNode.buildLinkedList(2, 1, 3, 8);
        var list2 = SinglyLinkedNode.buildLinkedList(7, 6, 3);
        var sum = SumListReversed.addSum(list1, list2);
        validateWithRange(sum, 9, 7, 6, 8);
    }

    @Test
    public void returnCoverOverAtUnequalListLengthByTwo() {
        var list1 = SinglyLinkedNode.buildLinkedList(6, 5, 3, 8);
        var list2 = SinglyLinkedNode.buildLinkedList(7, 6);
        var sum = SumListReversed.addSum(list1, list2);
        validateWithRange(sum, 3, 2, 4, 8);
    }
}
