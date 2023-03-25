package org.example.stackqueues;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FlexibleStackTest {

    private static FlexibleStack<Integer> newIntegerStackOfSize(int size) {
        return new FlexibleStack<>(size);
    }

    private static FlexibleStack<String> newStringStackOfSize(int size) {
        return new FlexibleStack<>(size);
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
        stack.push("");

        assertTrue(stack.isFull());

    }

    @Test
    public void overFillingTheStackCausesItToDoubleInSize() {
        var stack = newIntegerStackOfSize(4);
        stack.push(100);
        stack.push(200);
        stack.push(300);
        stack.push(400);


        stack.push(500);
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
    public void peekingAtEmptyStackThrowsExcetion() {
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
        var stack = newStringStackOfSize(3);
        stack.push("300");
        stack.push("Canton Coders");
        stack.push("A");

        assertThat(stack.search("Not found")).isEqualTo(-1);
        assertThat(stack.search("A")).isEqualTo(1);
        assertThat(stack.search("Canton Coders")).isEqualTo(2);
        assertThat(stack.search("300")).isEqualTo(3);
    }

    @Test
    public void canPopAtRemovesTheElementAtGivenPosition() {
        var stack = newStringStackOfSize(3);
        stack.push("300");
        stack.push("Canton Coders");
        stack.push("A");

        var position = stack.search("Canton Coders");
        assertThat(stack.popAt(position)).isEqualTo("Canton Coders");
    }

}
