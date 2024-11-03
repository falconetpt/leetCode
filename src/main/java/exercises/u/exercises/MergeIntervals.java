package exercises.u.exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparing(a -> a[0])); // O (n log n)
    final var list = new LinkedList<int[]>();
    list.add(new int[] { intervals[0][0], intervals[0][1] });

    for (int i = 1; i < intervals.length; i++) {
      final var last = list.peekLast();
      final var current = intervals[i];

      if (last[1] >= current[0]) {
        last[0] = Math.min(last[0], current[0]);
        last[1] = Math.max(current[1], last[1]);
      } else {
        list.add(new int[] { current[0], current[1]});
      }

    }

    return list.toArray(int[][]::new);
  }
}
