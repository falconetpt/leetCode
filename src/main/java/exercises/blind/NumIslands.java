package exercises.blind;

import java.awt.*;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class NumIslands {
  private static final List<Point> moves = List.of(
    new Point(0, 1),
    new Point(0, -1),
    new Point(1, 0),
    new Point(-1, 0)
  );

  public int numIslands(final char[][] grid) {
    final var set = new LinkedHashSet<Point>();

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '1') {
          set.add(new Point(i, j));
        }
      }
    }

    return numIslands(set);
  }

  private int numIslands(final LinkedHashSet<Point> set) {
    if (set.isEmpty()) {
      return 0;
    } else {
      final var basePoint = set.stream()
        .findFirst()
        .orElseThrow();
      expandNode(basePoint, set);
      return 1 + numIslands(set);
    }
  }

  private void expandNode(final Point basePoint, final LinkedHashSet<Point> set) {
    if (!set.isEmpty()) {
      set.remove(basePoint);
      moves.stream()
        .map(p -> new Point(basePoint.x + p.x, basePoint.y + p.y))
        .filter(set::contains)
        .forEach(p -> expandNode(p, set));
    }
  }
}
