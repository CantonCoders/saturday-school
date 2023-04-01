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
        // if top of temp is empty -> push to temp
        temp.push(pop());

        while (!isEmpty()) {
            var item = pop();
            sortItemOntoTemp(item, temp);
        }

        moveTempToStack(temp);
    }

    private void sortItemOntoTemp(T item, FixedStack<T> temp) {
        if (temp.peek().compareTo(item) <= 0) {
            // if top of temp is equal or less -> push to temp
            temp.push(item);
        } else {
            // if top of temp is greater -> move all from temp to stack, push to temp
            moveTempToStack(temp);
            temp.push(item);
        }
    }

    private void moveTempToStack(FixedStack<T> temp) {
        while (!temp.isEmpty()) {
            push(temp.pop());
        }
    }
}
