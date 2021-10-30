package exercises.array;

import java.awt.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrangesRooting {
  private static final List<Point> MOVES = List.of(
    new Point(0, 1),
    new Point(0, -1),
    new Point(1, 0),
    new Point(-1, 0)
  );


  public int orangesRotting(int[][] grid) {
    final var rottingOranges = getPoints(grid, 2, new HashSet<>());
    final var healthyOranges = getPoints(grid, 1, new HashSet<>());

    return orangesRotting(rottingOranges, healthyOranges, 0);
  }

  private int orangesRotting(final Set<Point> rottingOranges,
                             final Set<Point> healthyOranges,
                             final int target) {
    if (healthyOranges.isEmpty()) {
      return Math.max(0, target - 1);
    } else if (rottingOranges.isEmpty()) {
      return -1;
    } else {
      final var next = new HashSet<Point>();

      for (final var point : rottingOranges) {
        healthyOranges.remove(point);
        MOVES.stream()
          .map(p -> new Point(p.x + point.x, p.y + point.y))
          .filter(healthyOranges::contains)
          .forEach(next::add);
      }

      return orangesRotting(next, healthyOranges, target + 1);
    }
  }

  private <T extends Collection<Point>> T getPoints(final int[][] grid,
                                                    final int target,
                                                    final T points) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        final var element = grid[i][j];
        if (element == target) points.add(new Point(i, j));
      }
    }

    return points;
  }
}
