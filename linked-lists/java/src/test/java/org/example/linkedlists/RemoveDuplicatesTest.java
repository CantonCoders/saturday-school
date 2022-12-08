package org.example.linkedlists;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.linkedlists.LinkedListAssert.validateWithRange;

/**
 * Remove the duplicate elements from a Linked List. When removing
 * duplicate elements, always retain the first instance.
 */
public class RemoveDuplicatesTest {

    @Test
    public void thereCanBeOnlyOne() {
        var node = LinkedListNode.buildLinkedList(1);
        RemoveDuplicates.remove(node);
        validateWithRange(node, 1);
    }

    @Test
    public void noDuplicates() {
        var node = LinkedListNode.buildLinkedList(1, 2, 3, 4, 5);
        RemoveDuplicates.remove(node);
        validateWithRange(node, 1, 2, 3, 4, 5);
    }

    @Test
    public void onePairedDuplicate() {
        var node = LinkedListNode.buildLinkedList(1, 1, 2, 3, 4, 5);
        RemoveDuplicates.remove(node);
        validateWithRange(node, 1, 2, 3, 4, 5);
    }

    @Test
    public void oneNonPairedDuplicate() {
        var node = LinkedListNode.buildLinkedList(1, 2, 10, 9, 1, 5);
        RemoveDuplicates.remove(node);
        validateWithRange(node, 1, 2, 10, 9, 5);
    }

    @Test
    public void twoNonPairedDuplicate() {
        var node = LinkedListNode.buildLinkedList(5, 1, 2, 10, 9, 1, 5);
        RemoveDuplicates.remove(node);
        validateWithRange(node, 5, 1, 2, 10, 9);
    }

    /* EXTRA CREDIT */
    /* Refactor the method to take a LinkedListNode with an element that extends Object */
    @Test
    @Disabled
    public void makeTheMethodGeneric() {
//        var node = LinkedListNode.buildLinkedList("Cat", "Dog", "dog", "Cat", "Dog", "Bear", "Bird");
//        RemoveDups.remove(node);
//        validateWithRange(node, "Cat", "Dog", "dog", "Bear", "Bird");
    }



    /* TEST for the LinkedListNode builder function */
    @Test
    public void nodeListBuilder() {
        var node1 = LinkedListNode.buildLinkedList(1, 2, 3);

        assertThat(node1.getPrevious()).isNull();
        assertThat(node1.getElement()).isEqualTo(1);
        assertThat(node1.getNext()).isNotNull();

        var node2 = node1.getNext();
        assertThat(node2.getPrevious()).isEqualTo(node1);
        assertThat(node2.getNext()).isNotNull();
        assertThat(node2.getElement()).isEqualTo(2);

        var node3 = node2.getNext();
        assertThat(node3.getPrevious()).isSameAs(node2);
        assertThat(node3.getNext()).isNull();
        assertThat(node3.getElement()).isEqualTo(3);

    }


}
