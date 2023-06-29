package exercises.array;

import java.awt.Point;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class NumEnclaves {
  private final List<Point> MOVES = List.of(
    new Point(1, 0),
    new Point(-1, 0),
    new Point(0, 1),
    new Point(0, -1)
  );

  public int numEnclaves(final int[][] grid) {
    final var points = getPoints(grid);
    final var edgePoints = edgePoints(grid, points);

    removeEdge(points, edgePoints);

    return points.size();
  }

  private void removeEdge(final Set<Point> points, final LinkedList<Point> edgePoints) {
    while (!edgePoints.isEmpty()) {
      final var nextPoint = edgePoints.poll();
      points.remove(nextPoint);
      MOVES.stream()
        .map(p -> new Point(nextPoint.x + p.x, nextPoint.y + p.y))
        .filter(points::contains)
        .peek(points::remove)
        .forEach(edgePoints::add);
    }
  }

  private LinkedList<Point> edgePoints(final int[][] grid, final Set<Point> points) {
    final var result = new HashSet<Point>();

    for (final var point : points) {
      if (point.x == 0 || point.x == grid.length - 1
        || point.y == 0 || point.y == grid[0].length - 1) result.add(point);
    }

    return new LinkedList<>(result);
  }

  private Set<Point> getPoints(final int[][] grids) {
    final var result = new HashSet<Point>();

    for (int i = 0; i < grids.length; i++) {
      for(int j = 0; j < grids[i].length; j++) {
        if (grids[i][j] == 1) result.add(new Point(i, j));
      }
    }

    return result;
  }
}
