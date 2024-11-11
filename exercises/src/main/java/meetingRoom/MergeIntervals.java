package meetingRoom;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {
  public int[][] merge(int[][] intervals) {

    if (intervals.length == 0) return new int[][]{}; // base case

    Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
    final var result = new LinkedList<int[]>();
    result.addLast(intervals[0]);

    for (int i = 1; i < intervals.length; i++) {
      final var last = result.peekLast();
      final var element = intervals[i];

      if (last[1] >= element[0]) {
        last[1] = Math.max(last[1], element[1]);
      } else {
        result.addLast(new int[] {element[0], element[1]});
      }
    }

    return result.toArray(int[][]::new);
  }
}
