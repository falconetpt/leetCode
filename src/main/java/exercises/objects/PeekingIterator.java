package exercises.objects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

public class PeekingIterator implements Iterator<Integer> {
  private List<Integer> iterator;

  public PeekingIterator(final Iterator<Integer> iterator) {
    this.iterator = new ArrayList<Integer>();
    iterator.forEachRemaining(this.iterator::add);
  }

  // Returns the next element in the iteration without advancing the iterator.
  public Integer peek() {
    return iterator.get(0);
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public Integer next() {
    return iterator.remove(0);
  }

  @Override
  public boolean hasNext() {
    return iterator.size() > 0;
  }
}
