package org.example.stackqueues;

public class FlexibleStack<T extends Comparable<T>> extends FixedStack<T> {

    public FlexibleStack(int capacity) {
        super(capacity);
    }

    @Override
    public void push(T object) {
        if (size() == memory.length) {
            var newMemory = new StackValue[memory.length * 2];
            for (int i = 0; i < memory.length; i++) {
                newMemory[i] = memory[i];
            }
            memory = newMemory;
        }
        super.push(object);
    }
}
