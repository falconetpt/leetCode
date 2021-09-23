package exercises.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class IntervalsMerge {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    final var intervalList = new PriorityQueue<int[]>(Comparator.comparing(i -> i[0]));
    Arrays.stream(intervals).forEach(intervalList::add);
    intervalList.add(newInterval);

    final var result = new LinkedList<int[]>();

    while(!intervalList.isEmpty()) {
      final var poolValue = intervalList.poll();
      final var next = intervalList.peek();

      if (next == null) {
        result.add(poolValue);
      } else {
        if (poolValue[1] >= next[0]) {
          intervalList.poll();
          intervalList.add(new int[] { poolValue[0], next[1]});
        } else {
          result.add(poolValue);
        }
      }

    }

    return result.toArray(int[][]::new);
  }
}
