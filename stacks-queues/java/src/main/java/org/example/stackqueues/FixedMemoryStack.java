package org.example.stackqueues;

public class FixedMemoryStack extends ArrayStack {

  private StackValue[] memory;
  private int start;
  private int end;
  private int index;

  public FixedMemoryStack(StackValue[] memory, int start, int end) {
    this.memory = memory;
    this.start = start;
    this.end = end;
    this.index = 0;
  }

  @Override
  public StackValue[] getMemory() {
    return memory;
  }

  @Override
  protected int getIndex() {
    return index + start;
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
    return getIndex() - 1 == end;
  }

  @Override
  public boolean isEmpty() {
    return getIndex() == start;
  }

}
