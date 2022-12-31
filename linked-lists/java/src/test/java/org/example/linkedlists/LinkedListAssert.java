package org.example.linkedlists;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListAssert {


    @SafeVarargs
    public static <E> void validateWithRange(Node<E> node, E... expected) {
        var actual = new ArrayList<E>();

        actual.add(node.getElement());
        while (node.hasNext()) {
            node = node.getNext();
            actual.add(node.getElement());
        }
        assertThat(actual).containsExactly(expected);
    }

    @SafeVarargs
    public static <E> void validateListContains(Node<E> node, E... expected) {
        var actual = new ArrayList<E>();

        actual.add(node.getElement());
        while (node.hasNext()) {
            node = node.getNext();
            actual.add(node.getElement());
        }
        assertThat(actual).contains(expected);
    }

}
