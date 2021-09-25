package exercises.array;

import java.awt.*;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPath {
  private final static List<Point> MOVES = List.of(
    new Point(1, 0),
    new Point(0, 1),
    new Point(-1, 0),
    new Point(0, -1)
  );

  public int shortestPath(final int[][] grid, final int k) {
    final var priority = new PriorityQueue<>(
      Comparator.comparing(WeightedPoint::getWeight)
    );

    priority.add(new WeightedPoint(new Point(0, 0), 0));

//    shortestPath()
    return 2;
  }


  public class WeightedPoint {
    private Point point;
    private int weight;

    public WeightedPoint(final Point point, final int weight) {
      this.point = point;
      this.weight = weight;
    }

    public Point getPoint() {
      return point;
    }

    public int getWeight() {
      return weight;
    }
  }
}
