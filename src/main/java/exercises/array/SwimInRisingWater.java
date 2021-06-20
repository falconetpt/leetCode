package exercises.array;

import java.awt.Point;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class SwimInRisingWater {
  private static List<Point> moves = List.of(
    new Point(0, 1),
    new Point(1, 0),
    new Point(0, -1),
    new Point(-1, 0)
  );

  public int swimInWater(int[][] grid) {
    final var priorityQueue = new PriorityQueue<PointValue>(
      Comparator.comparing(x -> x.maxValue)
    );
    priorityQueue.add(new PointValue(new Point(0, 0), grid[0][0]));
    return swimInWater(grid, priorityQueue, new HashSet<>());
  }

  private int swimInWater(final int[][] grid,
                          final PriorityQueue<PointValue> priorityQueue,
                          final Set<Point> seen) {
    final var poll = priorityQueue.poll();
    final var point = poll.point;

    if (point.x == grid.length - 1
      && point.y == grid[point.x].length - 1) {
      return poll.maxValue;
    } else {
      seen.add(point);

      moves.stream()
        .map(p -> new Point(p.x + point.x, p.y + point.y))
        .filter(p -> !seen.contains(p))
        .filter(p -> validPoint(grid, p))
        .map(p -> new PointValue(p, Math.max(grid[p.x][p.y], poll.maxValue)))
        .forEach(priorityQueue::add);

      return swimInWater(grid, priorityQueue, seen);
    }
  }

  private boolean validPoint(final int[][] grid, final Point p) {
    try {
      final var value = grid[p.x][p.y];
      return true;
    } catch (final Exception e) {
      return false;
    }
  }

  public class PointValue {
    private final Point point;
    private final int maxValue;

    public PointValue(final Point point, final int maxValue) {
      this.point = point;
      this.maxValue = maxValue;
    }
  }
}
