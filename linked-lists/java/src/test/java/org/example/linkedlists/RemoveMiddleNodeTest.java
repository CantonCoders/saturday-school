package org.example.linkedlists;

import org.junit.jupiter.api.Test;

import static org.example.linkedlists.LinkedListAssert.validateWithRange;

public class RemoveMiddleNodeTest {

    @Test
    public void removeFromOddNumberShortList() {
        var node = LinkedListNode.buildLinkedList(3, 4, 5);
        RemoveMiddle.remove(node);
        validateWithRange(node, 3, 5);
    }

    @Test
    public void removeFromOddNumberLongList() {
        var node = LinkedListNode.buildLinkedList(3, 4, 5, 7, 1, 10, 99);
        RemoveMiddle.remove(node);
        validateWithRange(node, 3, 4, 5, 1, 10, 99);
    }

    @Test
    public void removeFromEvenNumberShortList() {
        var node = LinkedListNode.buildLinkedList(3, 4, 5, 10);
        RemoveMiddle.remove(node);
        validateWithRange(node, 3, 5, 10);
    }

    @Test
    public void removeFromEvenNumberLongList() {
        var node = LinkedListNode.buildLinkedList(3, 4, 5, 7, 1, 10, 99, 6);
        RemoveMiddle.remove(node);
        validateWithRange(node, 3, 4, 5, 1, 10, 99, 6);
    }
}
