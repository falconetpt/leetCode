package exercises.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class BallonPop {
  public int findMinArrowShots(final int[][] points) {
    Arrays.sort(points, Comparator.comparing(i -> i[0]));

    final var list = new LinkedList<int[]>();
    list.add(points[0]);

    for (int i = 1; i < points.length; i++) {
      final var prev = list.peekLast();
      final var element = points[i];

      if (prev[1] >= element[0]) {
        prev[0] = Math.max(prev[0], element[0]);
        prev[1] = Math.min(prev[1], element[1]);
      } else {
        list.addLast(element);
      }
    }

    return list.size();
  }
}
