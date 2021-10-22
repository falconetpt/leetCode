package exercises.blind;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeInterval {
  public int[][] merge(final int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
    final var result = new LinkedList<int[]>();
    result.addLast(intervals[0]);

    for (int i = 1; i < intervals.length; i++) {
      final var prev = result.peekLast();
      final var next = intervals[i];

      if (next[0] <= prev[1]) {
        prev[1] = Math.max(prev[1], next[1]);
      } else {
        result.addLast(next);
      }
    }

    return result.toArray(int[][]::new);
  }
}
