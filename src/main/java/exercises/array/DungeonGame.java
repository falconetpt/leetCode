package exercises.array;

import java.awt.*;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DungeonGame {
  private static final List<Point> MOVES = List.of(
    new Point(1, 0),
    new Point(0, 1)
  );

  public int calculateMinimumHP(final int[][] dungeon) {
    final var queue = new PriorityQueue<>(Comparator.comparing(WeightedPoint::getWeight));
    queue.add(new WeightedPoint(new Point(0, 0), 0));
    final var goal = new Point(dungeon.length - 1, dungeon[0].length - 1);

    return calculateMinimumHP(queue, dungeon, goal);
  }

  private int calculateMinimumHP(final PriorityQueue<WeightedPoint> queue,
                                 final int[][] dungeon,
                                 final Point goal) {
    final var nextPoint = queue.poll();
    final var point = nextPoint.point;
    final var weight = nextPoint.weight;

    if (point.equals(goal)) {
      return Math.max(1, nextPoint.weight + 1);
    } else {
      final var element = dungeon[point.x][point.y];
      MOVES.stream()
        .map(p -> new Point(point.x + p.x, point.y + p.y))
        .filter(p -> validPoint(dungeon, p))
        .forEach(p -> queue.add(new WeightedPoint(p, weight + element * -1)));

      return calculateMinimumHP(queue, dungeon, goal);
    }
  }

  private boolean validPoint(final int[][] dungeon, final Point p) {
    try {
      final var element = dungeon[p.x][p.y];
      return true;
    } catch (final ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }

  private class WeightedPoint {
    private final Point point;
    private final int weight;

    public WeightedPoint(final Point point, final int weight) {
      this.point = point;
      this.weight = weight;
    }

    public int getWeight() {
      return weight;
    }

    public Point getPoint() {
      return point;
    }
  }
}
