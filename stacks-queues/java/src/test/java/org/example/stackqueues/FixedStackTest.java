package org.example.stackqueues;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class FixedStackTest {

    @Test
    public void allocatesMemoryForTheStack() {
        var stack = new FixedStack(100);
        assertTrue(stack.isEmpty());
        assertFalse(stack.isFull());
        assertThat(stack.getBackingArray().length).isEqualTo(100);
    }

    @Test
    public void canPushToTheStack() {
        var stack = new FixedStack(3);
        stack.push(100);
        assertFalse(stack.isEmpty());
        assertFalse(stack.isFull());
        assertThat(stack.getBackingArray()).isEqualTo(new Object[] { 100, null, null });
    }

    @Test
    public void canFillTheStack() {
        var stack = new FixedStack(3);
        stack.push(300);
        stack.push("Canton Coders");
        stack.push('A');

        assertTrue(stack.isFull());
        assertThat(stack.getBackingArray()).isEqualTo(new Object[] { 300, "Canton Coders", 'A' });

    }

    @Test
    public void overFillingTheStackThrowsException() {
        var stack = new FixedStack(1);
        stack.push(300);
        assertThrows(StackFullException.class, () -> stack.push("Canton Coders"));
    }

    @Test
    public void canPopFromTopOfStack() {
        var stack = new FixedStack(3);
        stack.push(300);
        stack.push("Canton Coders");
        stack.push('A');

        assertThat(stack.pop()).isEqualTo('A');
        assertThat(stack.pop()).isEqualTo("Canton Coders");

        assertThat(stack.getBackingArray()).isEqualTo(new Object[] { 300, null, null });
    }

    @Test
    public void popFromEmptyStackThrowsException() {
        var stack = new FixedStack(3);
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    public void canPeekAtTopOfStack() {
        var stack = new FixedStack(3);
        stack.push(300);
        assertThat(stack.peek()).isEqualTo(300);

        stack.push("Canton Coders");
        assertThat(stack.peek()).isEqualTo("Canton Coders");

        stack.push('A');
        assertThat(stack.peek()).isEqualTo('A');
    }

    @Test
    public void peekingAtEmptyStackThrowsException() {
        var stack = new FixedStack(3);
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
        var stack = new FixedStack(3);
        stack.push(300);
        stack.push("Canton Coders");
        stack.push('A');

        assertThat(stack.search("Not found")).isEqualTo(-1);
        assertThat(stack.search('A')).isEqualTo(1);
        assertThat(stack.search("Canton Coders")).isEqualTo(2);
        assertThat(stack.search(300)).isEqualTo(3);
    }

    @Test
    public void canPopAtRemovesTheElementAtGivenPosition() {
        var stack = new FixedStack(9);
        stackPushValues(stack, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        assertThat(stack.popAt(6)).isEqualTo(4);

        assertThat(stack.getBackingArray()).isEqualTo(new Object[] { 1, 2, 3, 5, 6, 7, 8, 9, null });
    }

    @Test
    public void tracksNumberOfItemsOnTheStack() {
        var stack = new FixedStack(20);
        stackPushValues(stack, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        assertThat(stack.size()).isEqualTo(9);

        stack.push(10);
        assertThat(stack.size()).isEqualTo(10);

        stack.pop();
        stack.pop();
        stack.pop();
        assertThat(stack.size()).isEqualTo(7);
    }

    private void stackPushValues(FixedStack stack, int ...values) {
        for (var value : values) {
            stack.push(value);
        }
    }
}
