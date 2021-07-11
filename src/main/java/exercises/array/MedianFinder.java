package exercises.array;

import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

public class MedianFinder {

  private final SortedSet<Integer> numbers;

  /** initialize your data structure here. */
  public MedianFinder() {
    numbers = new TreeSet<>() {
    };
  }

  public void addNum(int num) {
    numbers.add(num);
  }

  public double findMedian() {
    final var x = numbers.toArray(Integer[]::new);

    if (x.length % 2 == 0) {
      return (x[x.length / 2] + x[x.length / 2 - 1]) / 2.0;
    } else {
      return x[x.length / 2];
    }
  }
}