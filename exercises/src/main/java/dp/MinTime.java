package dp;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class MinTime {
  private static Set<Point> MOVES = Set.of(
      new Point(1, 0),
      new Point(-1, 0),
      new Point(0, 1),
      new Point(0, -1)
  );

  public int minimumTime(int[][] grid) {
    final var seen = new HashSet<Point>();
    final var lastPoint = new Point(grid.length -1, grid[0].length - 1);

    return minimumTime(grid, new Point(0, 0), lastPoint, 0, seen);
  }

  private int minimumTime(int[][] grid, Point currentPoint,
                          Point lastPoint, int count, HashSet<Point> seen) {
    if (currentPoint.equals(lastPoint)) return 0;
    seen.add(currentPoint);

    final var newCount = count + 1;

    final var minMoves = MOVES.stream()
        .map(p -> new Point(p.x + currentPoint.x, p.y + currentPoint.y))
        .filter(p -> !seen.contains(p))
        .filter(p -> isValid(grid, p))
        .map(p -> {
          final var value = newCount - grid[p.x][p.y];

          if (currentPoint.x == 0 && currentPoint.y == 0 && value < 0) return -1;

          if (value < 0) {
            if (value % 2 == 0) return minimumTime(grid, p, lastPoint, newCount + value, seen) ;
            return minimumTime(grid, p, lastPoint, newCount + value + 1, seen) ;
          }

          return minimumTime(grid, p, lastPoint, newCount, seen);
        })
        .filter(v -> v != -1)
        .min(Comparator.comparingInt(a -> a));

    seen.remove(currentPoint);


    return minMoves.map(v -> v + 1).orElse(-1);
  }

  private boolean isValid(int[][] grid, Point point) {
    try {
      return grid[point.x][point.y] >= 0;
    } catch (ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }

  public record Point(int x, int y) {}
}
