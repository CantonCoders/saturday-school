package org.example.stackqueues;

import java.util.EmptyStackException;

public abstract class ArrayStack {

  protected abstract Object[] getMemory();
  protected abstract int getIndex();
  protected abstract void incrementIndex();
  protected abstract void decrementIndex();

  public Object[] getBackingArray() {
    return getMemory();
  }

  public void push(Object object) {
      if (isFull()) throw new StackFullException();

      getMemory()[getIndex()] = object;
      incrementIndex();
  }

  public Object pop() {
      if (isEmpty()) throw new EmptyStackException();

      decrementIndex();
      var object = getMemory()[getIndex()];
      getMemory()[getIndex()] = null;
      return object;
  }

  public Object peek() {
      if (isEmpty()) throw new EmptyStackException();

      return getMemory()[getIndex() - 1];
  }

  public abstract boolean isFull();

  public abstract boolean isEmpty();

  public int search(Object object) {
      for (int i = 0; i < getIndex(); i++) {
          if (object.equals(getMemory()[i])) {
              return getMemory().length - i;
          }
      }
      return -1;
  }

  public Object popAt(int position) {
      var object = peekAt(position);

      for (; position > 1; position--) {
          var i = getMemory().length - position;
          getMemory()[i] = getMemory()[i + 1];
      }
      getMemory()[getMemory().length - 1] = null;

      return object;
  }

  private Object peekAt(int position) {
      if (position < 1 || position > getMemory().length) throw new StackOutOfBoundsException();

      return getMemory()[getMemory().length - position];
  }

  public int size() {
      return getIndex();
  }

}
