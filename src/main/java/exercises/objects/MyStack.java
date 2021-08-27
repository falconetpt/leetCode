package exercises.objects;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
  private Queue<Integer> one;
  private Queue<Integer> two;

  /** Initialize your data structure here. */
  public MyStack() {
    one = new LinkedList<>(  );
    two = new LinkedList<>(  );
  }

  /** Push element x onto stack. */
  public void push(int x) {
    if (one.isEmpty()) {
      one.add( x );
      fill( two, one );
    } else {
      two.add( x );
      fill( one, two );
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
      return two.poll();
    } else {
      return one.poll();
    }
  }

  /** Get the top element. */
  public int top() {
    if (one.isEmpty()) {
      return two.peek();
    } else {
      return one.peek();
    }
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return one.isEmpty() && two.isEmpty();
  }
}
