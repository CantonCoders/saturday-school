package org.example.linkedlists;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SumListTest {

    @Test
    public void returnSingleDigitOnesPosition() {
        var list1 = SinglyLinkedNode.buildLinkedList(3);
        var list2 = SinglyLinkedNode.buildLinkedList(5);
        var sum = SumList.reverseOrderSum(list1, list2);
        assertThat(sum.getElement()).isEqualTo(8);
    }

    @Test
    public void returnSingleDigitAtTensPosition() {
        var list1 = SinglyLinkedNode.buildLinkedList(2, 7);
        var list2 = SinglyLinkedNode.buildLinkedList(4, 1);
        var sum = SumList.reverseOrderSum(list1, list2);
        assertThat(sum.getElement()).isEqualTo(8);
        sum = sum.getNext();
        assertThat(sum.getElement()).isEqualTo(6);
    }

    @Test
    public void returnCoverOverAtHundredsPosition() {
        var list1 = SinglyLinkedNode.buildLinkedList(7, 1, 6);
        var list2 = SinglyLinkedNode.buildLinkedList(2, 9, 5);
        var sum = SumList.reverseOrderSum(list1, list2);
        assertThat(sum.getElement()).isEqualTo(2);
        sum = sum.getNext();
        assertThat(sum.getElement()).isEqualTo(1);
        sum = sum.getNext();
        assertThat(sum.getElement()).isEqualTo(9);
    }
}
