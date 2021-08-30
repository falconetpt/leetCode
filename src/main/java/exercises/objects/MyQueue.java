package exercises.objects;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
  private Deque<Integer> one;
  private Deque<Integer> two;

  /** Initialize your data structure here. */
  public MyQueue() {
    one = new LinkedList<>(  );
    two = new LinkedList<>(  );
  }

  /** Push element x onto stack. */
  public void push(int x) {
    if (one.isEmpty()) {
      fill( two, one );
      one.add( x );
    } else {
      fill( one, two );
      two.add( x );
    }
  }

  private void fill(final Queue<Integer> base, Queue<Integer> dest) {
    while (!base.isEmpty()) {
      dest.add( base.poll() );
    }
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    if (one.isEmpty()) {
      return two.pollFirst();
    } else {
      return one.pollFirst();
    }
  }

  /** Get the top element. */
  public int peek() {
    if (one.isEmpty()) {
      return two.peekFirst();
    } else {
      return one.peekFirst();
    }
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return one.isEmpty() && two.isEmpty();
  }
}
