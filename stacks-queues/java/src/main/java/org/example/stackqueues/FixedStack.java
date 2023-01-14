package org.example.stackqueues;

public class FixedStack extends ArrayStack {

    protected Object[] memory;
    private int index;

    public FixedStack(int capacity) {
        memory = new Object[capacity];
        index = 0;
    }

    @Override
    public Object[] getMemory() {
        return memory;
    }

    @Override
    protected int getIndex() {
        return index;
    }

    @Override
    protected void incrementIndex() {
        index++;
    }

    @Override
    protected void decrementIndex() {
        index--;
    }

    @Override
    public boolean isFull() {
        return index == getMemory().length;
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

}
