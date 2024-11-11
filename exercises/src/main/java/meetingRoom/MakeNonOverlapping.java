package meetingRoom;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MakeNonOverlapping {
  public int eraseOverlapIntervals(int[][] intervals) {
    final Comparator<int[]> comparator = Comparator.comparing(p -> p[0]);
    final Comparator<int[]> nextComp = comparator.thenComparing(p -> -p[1]);
    Arrays.sort(intervals, nextComp);
    var count = 0;

    final var linkedList = new LinkedList<int[]>();
    linkedList.add(intervals[0]);


    for (int i = 1; i < intervals.length; i++) {
      final var current = intervals[i];
      final var last = linkedList.peekLast();

      // [1, 3]
      // [2, 5]

      if (last[1] > current[0]) {
        linkedList.pollLast();
        linkedList.addLast(new int[] {0, Math.min(last[1], current[1])});
        count++;
      } else {
        linkedList.addLast(current);
      }
    }

    return count;
  }
}
