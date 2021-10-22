package exercises.blind;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class InsertInterval {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    final var intervalsSorted= Stream.concat(Arrays.stream(intervals), Stream.of(newInterval))
      .sorted(Comparator.comparing(a -> a[0]))
      .toArray(int[][]::new);

    final var result = new LinkedList<int[]>();
    result.addLast(intervalsSorted[0]);

    for (int i = 1; i < intervalsSorted.length; i++) {
      final var prev = result.peekLast();
      final var next = intervalsSorted[i];

      if (next[0] <= prev[1]) {
        prev[1] = Math.max(prev[1], next[1]);
      } else {
        result.addLast(next);
      }
    }

    return result.toArray(int[][]::new);
  }
}
