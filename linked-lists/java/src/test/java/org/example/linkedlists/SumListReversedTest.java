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
        // 27
        var list1 = SinglyLinkedNode.buildLinkedList(7, 2);
        // 41
        var list2 = SinglyLinkedNode.buildLinkedList(1, 4);
        var sum = SumListReversed.addSum(list1, list2);
        
        // 68
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
        //   312
        var list1 = SinglyLinkedNode.buildLinkedList(2, 1, 3);
        // 8,367
        var list2 = SinglyLinkedNode.buildLinkedList(7, 6, 3, 8);
        var sum = SumListReversed.addSum(list1, list2);
        // 8,679
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
        // 8,356
        var list1 = SinglyLinkedNode.buildLinkedList(6, 5, 3, 8);
        //    67
        var list2 = SinglyLinkedNode.buildLinkedList(7, 6);
        var sum = SumListReversed.addSum(list1, list2);
        // 8,423
        validateWithRange(sum, 3, 2, 4, 8);
    }

    @Test
    public void sumAllNines() {
        // 9,999
        var list1 = SinglyLinkedNode.buildLinkedList(9,9,9,9);
        //     1
        var list2 = SinglyLinkedNode.buildLinkedList(1);
        var sum = SumListReversed.addSum(list1, list2);
        // 10,000
        validateWithRange(sum, 0,0,0,0,1);
    }
}
