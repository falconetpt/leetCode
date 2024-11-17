package finalPrep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class EraseOverlapIntervals {
  public int eraseOverlapIntervals(int[][] intervals) {
    final var linkedList = new LinkedList<int[]>();

    final Comparator<int[]> startComp = Comparator.comparing(a -> a[0]);
    final Comparator<int[]> endComp = startComp.thenComparing(a -> a[1]);

    Arrays.sort(intervals, endComp);

    var count = 0;

    linkedList.add(intervals[0]);

    for (int i = 1; i < intervals.length; i++) {
      final var last = linkedList.peekLast();
      final var value = intervals[i];

      if (last[1] > value[0]) {
        last[1] = Math.min(value[1], last[1]);
        count++;
      } else {
        linkedList.addLast(value);
      }
    }

    return count;
  }
}
