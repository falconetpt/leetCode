package exercises.u.exercises;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class MinStack {
  private final LinkedList<Integer> stack;
  private final PriorityQueue<Integer> priorityQueue;

  public MinStack() {
    stack = new LinkedList<>();
    priorityQueue = new PriorityQueue<>(Integer::compareTo);
  }

  public void push(int val) {
    stack.push(val);
    priorityQueue.add(val);
  }

  public void pop() {
    priorityQueue.remove(stack.pollFirst());
  }

  public int top() {
    return stack.peekFirst();
  }

  public int getMin() {
    return priorityQueue.peek();
  }
}
