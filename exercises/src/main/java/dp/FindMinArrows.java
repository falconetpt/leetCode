package dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class FindMinArrows {
  public int findMinArrowShots(int[][] points) {
    Arrays.sort(points, Comparator.comparing(a -> a[0]));
    final var priorityQueue = new LinkedList<int[]>();
    priorityQueue.add(points[0]);

    for (int i = 1; i < points.length; i++) {
      final var last = priorityQueue.peekLast();
      final var value = points[i];

      if (last[1] >= value[0]) {
        priorityQueue.pollLast();

        priorityQueue.addLast(new int[] {Math.max(last[1], value[0]), Math.min(last[1], value[1])});
      } else {
        priorityQueue.addLast(value);
      }
    }

    return priorityQueue.size();
  }
}
