package org.example.stackqueues;

import java.util.EmptyStackException;

public class ThreeInOneFixedStack {
    private final Object[] data;
    private final Stack stack1;
    private final Stack stack2;
    private final Stack stack3;

    public ThreeInOneFixedStack(int size) {
        if (size % 3 != 0)
            throw new InvalidAllocationException("Allocation size must be divisible by 3.");
        this.data = new Object[size];
        int stackSize = data.length / 3;
        stack1 = new Stack(0, stackSize);
        stack2 = new Stack(data.length / 3, stackSize);
        stack3 = new Stack(2 * data.length / 3, stackSize);
    }

    public Object[] getBackingArray() {
        return this.data;
    }

    public Stack getStack(StackNumber n) {
        return switch (n) {
            case ONE -> stack1;
            case TWO -> stack2;
            case THREE -> stack3;
        };
    }

    public void push(StackNumber stackNumber, Object object) {
        getStack(stackNumber).push(object);
    }

    public Object pop(StackNumber stackNumber) {
        return getStack(stackNumber).pop();
    }

    public Object peek(StackNumber stackNumber) {
        return getStack(stackNumber).peek();
    }


    public class Stack {
        int index;
        int offset;
        int size;

        public Stack(int offset, int size) {
            this.offset = offset;
            this.size = size;
            this.index = 0;
        }

        public void push(Object object) {
            if (index >= size)
                throw new StackFullException();
            data[index + offset] = object;
            index++;
        }

        public Object pop() {
            if (index == 0)
                throw new EmptyStackException();
            index--;
            var object = data[index + offset];
            data[index + offset] = null;
            return object;
        }

        public Object peek() {
            if (index == 0)
                throw new EmptyStackException();
            return data[index + offset - 1];
        }
    }

}
