package exercises.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoint {
  public int[][] kClosest(final int[][] points, final int k) {
    final var priorityQueue = new PriorityQueue<>(Comparator.comparing(Point::getDistance));

    for (final var point : points) {
      priorityQueue.add(new Point(point));
    }

    final var result = new int[k][2];
    var index = 0;

    while (!priorityQueue.isEmpty() && index < result.length) {
      result[index] = priorityQueue.poll().getPoint();
      index++;
    }

    return result;
  }

  public class Point {
    private final double distance;
    private final int[] point;

    public Point(final int[] point) {
      this.point = point;
      distance = Math.sqrt(
        point[0] * point[0] + point[1] * point[1]
      );
    }

    public double getDistance() {
      return distance;
    }

    public int[] getPoint() {
      return point;
    }
  }
}
