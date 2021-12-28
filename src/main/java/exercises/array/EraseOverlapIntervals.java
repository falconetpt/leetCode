package exercises.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class EraseOverlapIntervals {
  public int eraseOverlapIntervals(final int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparing(x -> x[0]));
    final var linkedList = new LinkedList<int[]>();
    linkedList.add(intervals[0]);
    var removed = 0;

    for (int i = 1; i < intervals.length; i++) {
      final var element = linkedList.peekLast();
      final var seen = intervals[i];

      if (element[1] > seen[0]) {
        linkedList.pollLast();
        final var toAdd = element[1] > seen[1]
          ? seen
          : element;
        linkedList.addLast(toAdd);
        removed++;
      } else {
        linkedList.addLast(seen);
      }
    }

    return removed;
  }
}
