package meetingRoom;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class InsertNewInterval {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    final var newArr = Arrays.copyOf(intervals, intervals.length + 1);
    newArr[intervals.length] = newInterval;
    Arrays.sort(newArr, Comparator.comparing(a -> a[0]));
    final var result = new LinkedList<int[]>();
    result.add(newArr[0]);

    for (int i = 1; i < newArr.length; i++) {
      final var element = newArr[i];
      final var last = result.peekLast();

      if (last[1] >= element[0]) {
        last[1] = Math.max(last[1], element[1]);
      } else {
        result.add(element);
      }

    }

    return result.toArray(int[][]::new);
  }
}
