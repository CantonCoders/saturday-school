package org.example.stackqueues;

public class FlexibleStack extends FixedStack {

    public FlexibleStack(int capacity) {
        super(capacity);
    }

    @Override
    public void push(Object object) {
        if (size() == memory.length) {
            var newMemory = new Object[memory.length * 2];
            for (int i = 0; i < memory.length; i++) {
                newMemory[i] = memory[i];
            }
            memory = newMemory;
        }
        super.push(object);
    }
}
