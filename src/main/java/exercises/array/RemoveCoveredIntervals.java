package exercises.array;

import java.util.Arrays;

public class RemoveCoveredIntervals {
  public int removeCoveredIntervals(final int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] == b[0]
      ? b[1] - a[1]
      : a[0] - b[0]);
    if (intervals.length < 1) return intervals.length;

    var max = intervals[0][1];
    var counter = 1;

    for (final var interval : intervals) {
      if (interval[1] > max) {
        counter++;
        max = interval[1];
      }
    }

    return counter;
  }
}
