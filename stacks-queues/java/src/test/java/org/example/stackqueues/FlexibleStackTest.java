package org.example.stackqueues;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FlexibleStackTest {

    @Test
    public void allocatesMemoryForTheStack() {
        var stack = new FlexibleStack(100);
        assertTrue(stack.isEmpty());
        assertFalse(stack.isFull());
        assertThat(stack.getBackingArray().length).isEqualTo(100);
    }

    @Test
    public void canPushToTheStack() {
        var stack = new FlexibleStack(3);
        stack.push(100);
        assertFalse(stack.isEmpty());
        assertFalse(stack.isFull());
        assertThat(stack.getBackingArray()).isEqualTo(new Object[] { 100, null, null });
    }

    @Test
    public void canFillTheStack() {
        var stack = new FlexibleStack(3);
        stack.push(300);
        stack.push("Canton Coders");
        stack.push('A');

        assertTrue(stack.isFull());
        assertThat(stack.getBackingArray()).isEqualTo(new Object[] { 300, "Canton Coders", 'A' });

    }

    @Test
    public void overFillingTheStackCausesItToDoubleInSize() {
        var stack = new FlexibleStack(4);
        stack.push(100);
        stack.push(200);
        stack.push(300);
        stack.push(400);
        assertThat(stack.getBackingArray()).isEqualTo(new Object[] { 100, 200, 300, 400 });


        stack.push("Canton Coders");
        assertThat(stack.getBackingArray()).isEqualTo(new Object[] { 100, 200, 300, 400, "Canton Coders", null, null, null });
    }

    @Test
    public void canPopFromTopOfStack() {
        var stack = new FlexibleStack(3);
        stack.push(300);
        stack.push("Canton Coders");
        stack.push('A');

        assertThat(stack.pop()).isEqualTo('A');
        assertThat(stack.pop()).isEqualTo("Canton Coders");

        assertThat(stack.getBackingArray()).isEqualTo(new Object[] { 300, null, null });
    }

    @Test
    public void popFromEmptyStackThrowsException() {
        var stack = new FlexibleStack(3);
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    public void canPeekAtTopOfStack() {
        var stack = new FlexibleStack(3);
        stack.push(300);
        assertThat(stack.peek()).isEqualTo(300);

        stack.push("Canton Coders");
        assertThat(stack.peek()).isEqualTo("Canton Coders");

        stack.push('A');
        assertThat(stack.peek()).isEqualTo('A');
    }

    @Test
    public void peekingAtEmptyStackThrowsExcetion() {
        var stack = new FlexibleStack(3);
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
        var stack = new FlexibleStack(3);
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
        var stack = new FlexibleStack(3);
        stack.push(300);
        stack.push("Canton Coders");
        stack.push('A');

        var position = stack.search("Canton Coders");
        assertThat(stack.popAt(position)).isEqualTo("Canton Coders");

        assertThat(stack.getBackingArray()).isEqualTo(new Object[] { 300, 'A', null });
    }

}
