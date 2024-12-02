package dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class InsertInterval {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    final var array = Arrays.copyOf(intervals, intervals.length + 1);
    array[intervals.length] = newInterval;
    Arrays.sort(array, Comparator.comparing(a -> a[0]));

    final var linkedList = new LinkedList<int[]>();
    linkedList.add(array[0]);


    for (int i = 1; i < array.length; i++) {
      final var prev = linkedList.peekLast();
      final var element = array[i];

      if (prev[1] >= element[0]) {
        prev[0] = Math.min(prev[0], element[0]);
        prev[1] = Math.min(prev[1], element[1]);
      } else {
        linkedList.add(element);
      }
    }


    return linkedList.toArray(int[][]::new);
  }
}
