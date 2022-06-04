package exercises.objects;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NestedIteratorSol {
  public class NestedIterator implements Iterator<Integer> {
    private final LinkedList<Integer> queue;

    public NestedIterator(List<NestedInteger> nestedList) {
      queue = new LinkedList<>();
      nestedList.forEach(this::addToQueue);
    }

    private void addToQueue(final NestedInteger nestedInteger) {
      if (nestedInteger.isInteger()) {
        queue.add(nestedInteger.getInteger());
      } else {
        nestedInteger.getList().forEach(this::addToQueue);
      }
    }

    @Override
    public Integer next() {
      return queue.pollFirst();
    }

    @Override
    public boolean hasNext() {
      return !queue.isEmpty();
    }
  }


  // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
  public interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
  }
}
