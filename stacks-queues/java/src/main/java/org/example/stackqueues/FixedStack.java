package org.example.stackqueues;

public class FixedStack<T extends Comparable<T>> extends ArrayStack<T> {

    protected StackValue<T>[] memory;
    private int index;

    public FixedStack(int capacity) {
        memory = new StackValue[capacity];
        index = 0;
    }

    @Override
    public StackValue<T>[] getMemory() {
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

    public void sort() {
        var temp = new FixedStack<T>(this.getMemory().length);
        while (!isEmpty()) {
            var item = pop();
            while (!temp.isEmpty() && temp.peek().compareTo(item) > 0) {
                push(temp.pop());
            }
            temp.push(item);
        }

        moveTempToStack(temp);
    }

    private void moveTempToStack(FixedStack<T> temp) {
        while (!temp.isEmpty()) {
            push(temp.pop());
        }
    }
}
