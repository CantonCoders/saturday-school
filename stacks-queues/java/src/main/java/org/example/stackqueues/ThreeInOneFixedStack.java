package org.example.stackqueues;

public class ThreeInOneFixedStack<T extends Comparable<T>> {

    private final ArrayStack.StackValue<T>[] memory;
    private final FixedMemoryStack stack1;
    private final FixedMemoryStack stack2;
    private final FixedMemoryStack stack3;

    public ThreeInOneFixedStack(int size) {
        if (size % 3 != 0) throw new InvalidAllocationException("Allocation size must be divisible by 3.");

        memory = new ArrayStack.StackValue[size];

        var capacity = memory.length / 3;
        stack1 = new FixedMemoryStack(memory, 0, capacity - 1);
        stack2 = new FixedMemoryStack(memory, capacity, capacity * 2 - 1);
        stack3 = new FixedMemoryStack(memory, capacity * 2, capacity * 3 - 1);
    }

    public Object[] getBackingArray() {
        return memory;
    }

    public void push(StackNumber stackNumber, T object) {
        getStack(stackNumber).push(object);
    }

    public Object pop(StackNumber stackNumber) {
        return getStack(stackNumber).pop();
    }

    public Object peek(StackNumber stackNumber) {
        return getStack(stackNumber).peek();
    }

    private FixedMemoryStack getStack(StackNumber stackNumber) {
        return switch (stackNumber) {
            case ONE -> stack1;
            case TWO -> stack2;
            default -> stack3;
        };
    }

}
