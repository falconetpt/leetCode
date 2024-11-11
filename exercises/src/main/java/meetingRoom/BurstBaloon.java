package meetingRoom;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class BurstBaloon {
  public int findMinArrowShots(int[][] points) {
    Arrays.sort(points, Comparator.comparing(p -> p[0]));

    final var result = new LinkedList<int[]>();
    result.add(points[0]);

    for (int i = 1; i < points.length; i++) {
      final var last = result.peekLast();
      final var current = points[i];

      if (last[1] >= current[0]) {
        last[0] = Math.max(last[0], current[0]);
        last[1] = Math.min(last[1], current[1]);
      } else {
        result.add(current);
      }
    }


    return result.size();
  }
}
