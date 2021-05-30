package exercises.array;

import java.awt.*;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class ShortestBridge {
  private static final List<Point> moves = List.of(
    new Point(0, 1),
    new Point(1, 0),
    new Point(0, -1),
    new Point(-1, 0)

  );
  private static final Comparator<PriorityPoint> priorityPointComp =
    Comparator.comparing(a -> a.weight);

  public int shortestBridge(int[][] grid) {
    final var priorityQueue = new PriorityQueue<>(priorityPointComp);
    final var firstLand = getFirstLand(grid);
    final var seen = new HashSet<Point>();
    priorityQueue.add(firstLand);
    seen.add(firstLand.point);

    return shortestBridge(grid, priorityQueue, seen);
  }

  private int shortestBridge(int[][] grid,
                             PriorityQueue<PriorityPoint> priorityQueue,
                             Set<Point> seen) {
    final var next = priorityQueue.poll();

    if (next.weight > 0 && next.value == 1) {
      return next.weight;
    } else {
      final var nextPoint = next.point;
      moves.stream()
        .map(p -> new Point(p.x + nextPoint.x, p.y + nextPoint.y))
        .filter(p -> !seen.contains(p))
        .filter(p -> isValid(p, grid))
        .peek(seen::add)
        .map(p -> createPriorityPoint(p, next, grid))
        .forEach(priorityQueue::add);

      return shortestBridge(grid, priorityQueue, seen);

    }
  }

  private PriorityPoint createPriorityPoint(Point p, PriorityPoint next, int[][] grid) {
    final var value = grid[p.x][p.y];
    return new PriorityPoint(p, next.weight + (value == 1 ? 0 : 1), value);
  }

  private boolean isValid(Point p, int[][] grid) {
    try {
      final var next = grid[p.x][p.y];
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  private PriorityPoint getFirstLand(final int[][] grid) {
    for (var i = 0; i < grid.length; i++) {
      for (var j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          final var point = new Point(i, j);
          return new PriorityPoint(point, 0, 1);
        }
      }
    }
    return null;
  }


  private class PriorityPoint {
    private Point point;
    private Integer weight;
    private Integer value;

    PriorityPoint(final Point point, final Integer weight, final Integer value) {
      this.point = point;
      this.weight = weight;
      this.value = value;
    }
  }
}
