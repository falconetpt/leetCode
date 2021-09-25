package exercises.array;

import java.awt.*;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

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

    priority.add(new WeightedPoint(new Point(0, 0), 0, k));

    return shortestPath(priority, grid, k, new HashSet<>());
  }

  private int shortestPath(final PriorityQueue<WeightedPoint> points,
                          final int[][] grid,
                          final int k,
                          final Set<Point> seen) {
    if (points.isEmpty()) {
      return -1;
    } else {
      final var nextElement = points.poll();
      final var newSeen = new HashSet<>(seen);
      newSeen.add(nextElement.point);
      final var point = nextElement.point;
      final var weight = nextElement.weight;
      var newK = grid[point.x][point.y] == 1
        ? k - 1
        : k;

      if (point.x == grid.length - 1 && point.y == grid[point.x].length - 1) {
        return weight;
      } else {
        MOVES.stream()
          .map(p -> new Point(p.x + point.x, p.y + point.y))
          .filter(p -> !newSeen.contains(p))
          .filter(p -> validPoint(grid, p))
          .filter(p -> grid[p.x][p.y] != 1 || newK - 1 >= 0)
          .map(p -> new WeightedPoint(p, weight + 1, newK))
          .filter(w -> w.steps >= 0)
          .forEach(points::add);

        return shortestPath(points, grid, k, newSeen);
      }
    }
  }

  private boolean validPoint(final int[][] grid, final Point point) {
    try {
      final var val = grid[point.x][point.y];
      return true;
    } catch (final ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }


  public class WeightedPoint {
    private Point point;
    private int weight;
    private int steps;

    public WeightedPoint(final Point point,
                         final int weight,
                         final int steps) {
      this.point = point;
      this.weight = weight;
      this.steps = steps;
    }

    public Point getPoint() {
      return point;
    }

    public int getWeight() {
      return weight;
    }
  }
}
