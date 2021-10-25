package exercises.objects;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class MinStack {
  private LinkedList<Integer> priorityQueue;

  public MinStack() {
    this.priorityQueue = new LinkedList<>();
  }

  public void push(int val) {
    var index = getIndex(val);

    priorityQueue.add(index, val);
  }

  public void pop() {
    priorityQueue.removeLast();
  }

  public int top() {
    return priorityQueue.peekLast();
  }

  public int getMin() {
    return priorityQueue.peekFirst();
  }

  private int getIndex(int val) {
    final var listSize = priorityQueue.size();
    var index = 0;

    while (index < listSize) {
      if (val <= priorityQueue.get(index)) return index;
      index++;
    }

    return index;
  }
}
