package finalPrep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparing(a -> a[0]));

    final var linkedList = new LinkedList<int[]>();
    linkedList.add(intervals[0]);

    for (int i = 1; i < intervals.length; i++) {
      final var prev = linkedList.peekLast();
      final var current = intervals[i];

      if (prev[1] >= current[0]) {
        prev[1] = Math.max(prev[1], current[1]);
      } else {
        linkedList.add(current);
      }

    }

    return linkedList.toArray(int[][]::new);
  }
}
