package org.example.linkedlists;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IntersectionTest {

    @Test
    public void nodesDoNotIntersect() {
        var left = SinglyLinkedNode.buildLinkedList(1, 3, 5);
        var right = SinglyLinkedNode.buildLinkedList(11, 13, 14);

        assertThat(Intersection.findIntersect(left, right)).isNull();
    }

    @Test
    public void nodesIntersectAtTail() {
        var intersect = SinglyLinkedNode.buildLinkedList(7);

        var left = SinglyLinkedNode.buildLinkedList(1, 3, 5);
        var right = SinglyLinkedNode.buildLinkedList(11, 13, 14);

        getListTail(left).setNext(intersect);
        getListTail(right).setNext(intersect);

        assertThat(Intersection.findIntersect(left, right)).isEqualTo(intersect);
    }

    @Test
    public void nodesIntersect() {
        var intersect = SinglyLinkedNode.buildLinkedList(2, 7);

        var left = SinglyLinkedNode.buildLinkedList(1, 3, 5);
        var right = SinglyLinkedNode.buildLinkedList(11, 13, 14);

        getListTail(left).setNext(intersect);
        getListTail(right).setNext(intersect);

        assertThat(Intersection.findIntersect(left, right)).isEqualTo(intersect);
    }

    @Test
    public void nodesEqualElementsDoNotIntersect() {
        var value = Integer.valueOf(2);

        var left = SinglyLinkedNode.buildLinkedList(1, 3, 5, value, 7);
        var right = SinglyLinkedNode.buildLinkedList(11, 13, 14, value, 7);

        assertThat(Intersection.findIntersect(left, right)).isNull();
    }

    @Test
    public void unequalLengthListIntersect() {
        var intersect = SinglyLinkedNode.buildLinkedList(5, 2, 7);

        var left = SinglyLinkedNode.buildLinkedList(1, 3, 5, 11, 12);
        var right = SinglyLinkedNode.buildLinkedList(11, 13, 14);

        getListTail(left).setNext(intersect);
        getListTail(right).setNext(intersect);

        assertThat(Intersection.findIntersect(left, right)).isEqualTo(intersect);
    }

    @Test
    public void intersectByReference() {
        var value = Integer.valueOf(5);
        var intersect = SinglyLinkedNode.buildLinkedList(value, 2, 7);

        var left = SinglyLinkedNode.buildLinkedList(value, 13, 14);
        var right = SinglyLinkedNode.buildLinkedList(1, 3, value, 11, 14);

        getListTail(left).setNext(intersect);
        getListTail(right).setNext(intersect);

        assertThat(Intersection.findIntersect(left, right)).isEqualTo(intersect);
    }

    private static <E> SinglyLinkedNode<E> getListTail(SinglyLinkedNode<E> node) {
        while (node.hasNext()) {
            node = node.getNext();
        }
        return node;
    }
}
