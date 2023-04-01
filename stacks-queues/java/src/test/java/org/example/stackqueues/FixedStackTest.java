package org.example.stackqueues;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class FixedStackTest {


    private static FixedStack<Integer> newIntegerStackOfSize(int size) {
        return new FixedStack<>(size);
    }

    private static FixedStack<String> newStringStackOfSize(int size) {
        return new FixedStack<>(size);
    }

    @Test
    public void allocatesMemoryForTheStack() {
        var stack = newIntegerStackOfSize(100);
        assertTrue(stack.isEmpty());
        assertFalse(stack.isFull());
    }

    @Test
    public void canPushToTheStack() {
        var stack = newIntegerStackOfSize(3);
        stack.push(100);
        assertFalse(stack.isEmpty());
        assertFalse(stack.isFull());
    }

    @Test
    public void canFillTheStack() {
        var stack = newStringStackOfSize(3);
        stack.push("300");
        stack.push("Canton Coders");
        stack.push("A");

        assertTrue(stack.isFull());
    }

    @Test
    public void overFillingTheStackThrowsException() {
        var stack = newIntegerStackOfSize(1);
        stack.push(300);
        assertThrows(StackFullException.class, () -> stack.push(400));
    }

    @Test
    public void canPopFromTopOfStack() {
        var stack = newStringStackOfSize(3);
        stack.push("300");
        stack.push("Canton Coders");
        stack.push("A");

        assertThat(stack.pop()).isEqualTo("A");
        assertThat(stack.pop()).isEqualTo("Canton Coders");
    }

    @Test
    public void popFromEmptyStackThrowsException() {
        var stack = newIntegerStackOfSize(3);
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    public void canPeekAtTopOfStack() {
        var stack = newStringStackOfSize(3);
        stack.push("300");
        assertThat(stack.peek()).isEqualTo("300");

        stack.push("Canton Coders");
        assertThat(stack.peek()).isEqualTo("Canton Coders");

        stack.push("A");
        assertThat(stack.peek()).isEqualTo("A");
    }

    @Test
    public void peekingAtEmptyStackThrowsException() {
        var stack = newIntegerStackOfSize(3);
        assertThrows(EmptyStackException.class, stack::peek);
    }

    @Test
    /*
     * Returns the 1-based position where an object is on this stack. If the object
     * o occurs as an item in this stack, this method returns the distance from the
     * top of the stack of the occurrence nearest the top of the stack; the topmost
     * item on the stack is considered to be at distance 1. The equals method is
     * used to compare o to the items in this stack.
     */
    public void searchingReturnsOneBasedPositionOfObject() {
        var stack = newStringStackOfSize(5);
        stack.push("300");
        stack.push("Canton Coders");
        stack.push("A");
        stack.push("B");
        stack.push("C");

        assertThat(stack.search("Not found")).isEqualTo(-1);
        assertThat(stack.search("A")).isEqualTo(3);
        assertThat(stack.search("Canton Coders")).isEqualTo(4);
        assertThat(stack.search("300")).isEqualTo(5);
    }

    @Test
    public void canPopAtRemovesTheElementAtGivenPosition() {
        var stack = newIntegerStackOfSize(9);
        stackPushValues(stack, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        assertThat(stack.popAt(6)).isEqualTo(4);
    }

    @Test
    public void popAtOutOfBoundsIndex() {
        var stack = newIntegerStackOfSize(9);
        stackPushValues(stack, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        assertThrows(StackOutOfBoundsException.class, () -> stack.popAt(0));
        assertThrows(StackOutOfBoundsException.class, () -> stack.popAt(10));
    }

    @Test
    public void tracksNumberOfItemsOnTheStack() {
        var stack = newIntegerStackOfSize(20);
        stackPushValues(stack, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        assertThat(stack.size()).isEqualTo(9);

        stack.push(10);
        assertThat(stack.size()).isEqualTo(10);

        stack.pop();
        stack.pop();
        stack.pop();
        assertThat(stack.size()).isEqualTo(7);
    }

    @Test
    public void shouldReturnTheMinimumValueInTheStack() {
        var stack = newIntegerStackOfSize(20);
        stackPushValues(stack, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        assertThat(stack.min()).isEqualTo(1);
    }

    @Test
    public void shouldTrackWhenNewMinimumValuesAreAdded() {
        var stack = newIntegerStackOfSize(20);

        stackPushValues(stack, 4, 1, 3, 2, 0);
        // 0, 0
        // 2, 1
        // 3, 1
        // 1, 1
        // 4, 4

        assertThat(stack.min()).isEqualTo(0);
        stack.pop();
        assertThat(stack.min()).isEqualTo(1);
    }

    @Test
    public void shouldSortSmallerOfTwoItems() {
        var stack = newIntegerStackOfSize(20);

        stackPushValues(stack, 0, 4);
        stack.sort();

        assertThat(stack.pop()).isEqualTo(0);
        assertThat(stack.pop()).isEqualTo(4);
        assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    public void shouldSortSmallerOfThreeItems() {
        var stack = newIntegerStackOfSize(20);

        stackPushValues(stack, 0, -1, 4);
        stack.sort();

        assertThat(stack.pop()).isEqualTo(-1);
        assertThat(stack.pop()).isEqualTo(0);
        assertThat(stack.pop()).isEqualTo(4);
        assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    public void shouldSortSmallerOfManyItems() {
        var stack = newIntegerStackOfSize(20);

        stackPushValues(stack, -1, 4, 2, 9, 4, 3, 0);
        stack.sort();

        assertThat(stack.pop()).isEqualTo(-1);
        assertThat(stack.pop()).isEqualTo(0);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.pop()).isEqualTo(4);
        assertThat(stack.pop()).isEqualTo(4);
        assertThat(stack.pop()).isEqualTo(9);
        assertThat(stack.isEmpty()).isTrue();
    }

    private void stackPushValues(FixedStack stack, int... values) {
        for (var value : values) {
            stack.push(value);
        }
    }
}
