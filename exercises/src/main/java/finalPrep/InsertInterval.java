package finalPrep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class InsertInterval {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    final var newArray = Arrays.copyOf(intervals, intervals.length + 1); // O(n) time | O(n) space
    newArray[intervals.length] = newInterval;

    Arrays.sort(newArray, Comparator.comparing(a -> a[0]));

    final var linkedList = new LinkedList<int[]>();
    linkedList.add(newArray[0]);

    for (int i = 1; i < newArray.length; i++) {
      final var element = newArray[i];
      final var last = linkedList.peekLast();

      if (last[1] >= element[0]) {
        last[1] = Math.max(element[1], last[1]);
      } else {
        linkedList.add(element);
      }
    }


    return linkedList.toArray(int[][]::new);
  }
}
