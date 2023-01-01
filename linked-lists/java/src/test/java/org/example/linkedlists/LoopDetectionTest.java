package org.example.linkedlists;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoopDetectionTest {

    @Test
    public void listDoesNotLoop() {
        var node = SinglyLinkedNode.buildLinkedList(1, 3, 5, 11, 12);
        assertThat(LoopDetection.findLoopNode(node)).isNull();
    }

    @Test
    public void doesNotLoopOnEqualElements() {
        var value = Integer.valueOf(5);
        var node = SinglyLinkedNode.buildLinkedList(1, 3, value, 11, 12, value);
        assertThat(LoopDetection.findLoopNode(node)).isNull();
    }

    @Test
    public void loopsOnNodeReference() {
        var loopStart = new SinglyLinkedNode<>(3);
        var segment1 = SinglyLinkedNode.buildLinkedList(1, 3);
        var segment2 = SinglyLinkedNode.buildLinkedList(11, 12);

        getListTail(segment1).setNext(loopStart);
        loopStart.setNext(segment2);
        getListTail(segment2).setNext(loopStart);

        assertThat(LoopDetection.findLoopNode(segment1)).isSameAs(loopStart);
    }

    @Test
    public void largeLoopSet() {
        var value = Integer.valueOf(5);
        var loopStart = new SinglyLinkedNode<>(3);
        var segment1 = SinglyLinkedNode.buildLinkedList(1, 3, value, 39, 12, 8, 33);
        var segment2 = SinglyLinkedNode.buildLinkedList(11, 12, value, 23, 91, 100, 21, 48);

        getListTail(segment1).setNext(loopStart);
        loopStart.setNext(segment2);
        getListTail(segment2).setNext(loopStart);

        assertThat(LoopDetection.findLoopNode(segment1)).isSameAs(loopStart);
    }

    private static <E> SinglyLinkedNode<E> getListTail(SinglyLinkedNode<E> node) {
        while (node.hasNext()) {
            node = node.getNext();
        }
        return node;
    }

}
