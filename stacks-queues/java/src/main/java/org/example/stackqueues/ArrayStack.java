package org.example.stackqueues;

import java.util.EmptyStackException;
import java.util.Objects;

public abstract class ArrayStack<T extends Comparable<T>> {

    public static class StackValue<T extends Comparable<T>> {
        T value;
        T min;

        public StackValue(T value, T min) {
            this.value = value;
            if (min == null || value.compareTo(min) < 0) {
                this.min = value;
            } else {
                this.min = min;
            }
        }

        public boolean valueEquals(T value) {
            return this.value.compareTo(value) == 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Comparable<?> that)) return false;
            return Objects.equals(value, that);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

  protected abstract StackValue<T>[] getMemory();
  protected abstract int getIndex();
  protected abstract void incrementIndex();
  protected abstract void decrementIndex();

  public void push(T object) {
      if (isFull()) throw new StackFullException();

      T minValue = null;
      if (!isEmpty()) {
          minValue = min();
      }

      getMemory()[getIndex()] = new StackValue<>(object, minValue);
      incrementIndex();
  }

    public T min() {
        if (isEmpty()) throw new EmptyStackException();

        return getMemory()[getIndex() - 1].min;
    }

  public T pop() {
      if (isEmpty()) throw new EmptyStackException();

      decrementIndex();
      var object = getMemory()[getIndex()];
      getMemory()[getIndex()] = null;
      return object.value;
  }

  public T peek() {
      if (isEmpty()) throw new EmptyStackException();

      return getMemory()[getIndex() - 1].value;
  }

  public abstract boolean isFull();

  public abstract boolean isEmpty();

  public int search(T object) {
      for (int i = 0; i < getIndex(); i++) {
          if (getMemory()[i].valueEquals(object)) {
              return getMemory().length - i;
          }
      }
      return -1;
  }

  public T popAt(int position) {
      T object = peekAt(position);

      for (; position > 1; position--) {
          var i = getMemory().length - position;
          getMemory()[i] = getMemory()[i + 1];
      }
      getMemory()[getMemory().length - 1] = null;

      return object;
  }

  private T peekAt(int position) {
      if (position < 1 || position > getMemory().length) throw new StackOutOfBoundsException();

      return getMemory()[getMemory().length - position].value;
  }

  public int size() {
      return getIndex();
  }

}
