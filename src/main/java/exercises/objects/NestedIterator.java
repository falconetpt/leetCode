package exercises.objects;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
    }

    private LinkedList<Integer> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new LinkedList<>(  );
        generateIterator(nestedList.iterator(), list);
    }


    @Override
    public Integer next() {
        return list.pollFirst();
    }

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }

    private void generateIterator(Iterator<NestedInteger> iterator, LinkedList<Integer> list) {
        if (iterator.hasNext()) {
            NestedInteger next = iterator.next();
            if (next.isInteger()) {
                list.add( next.getInteger() );
            } else {
                generateIterator( next.getList().iterator(), list );
            }
        }
    }
}
