package org.example.linkedlists;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Find the nth Node from the end of a Linked List.
 */
public class FindNthToLastTest {

    @Test
    public void findSingleNode() {
        var head = LinkedListNode.buildLinkedList(1);
        var node = FindNode.findNthFromEnd(0, head);
        assertThat(node.getElement()).isEqualTo(1);
    }

    @Test
    public void findLastNodeAmountTwo() {
        var head = LinkedListNode.buildLinkedList(1, 2);
        var node = FindNode.findNthFromEnd(0, head);
        assertThat(node.getElement()).isEqualTo(2);
    }

    @Test
    public void findNodeSecondToLastAmongTwo() {
        var head = LinkedListNode.buildLinkedList(1, 2);
        var node = FindNode.findNthFromEnd(1, head);
        assertThat(node.getElement()).isEqualTo(1);
    }

    @Test
    public void findNodeSecondToLastAmongFive() {
        var head = LinkedListNode.buildLinkedList(1, 2, 4, 3, 7);
        var node = FindNode.findNthFromEnd(2, head);
        assertThat(node.getElement()).isEqualTo(4);
    }

    @Test
    public void findNode5thToLastAmongFive() {
        var head = LinkedListNode.buildLinkedList(1, 2, 4, 3, 7, 10);
        var node = FindNode.findNthFromEnd(5, head);
        assertThat(node.getElement()).isEqualTo(1);
    }

    @Test
    public void nthIsLargerThanList() {
        var head = LinkedListNode.buildLinkedList(1, 2, 4, 3, 7, 10);
        var node = FindNode.findNthFromEnd(6, head);
        assertThat(node).isNull();
    }
}
