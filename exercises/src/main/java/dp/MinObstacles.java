package dp;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinObstacles {
  private final static Set<Point> MOVES = Set.of(
      new Point(0, 1),
      new Point(0, -1),
      new Point(1, 0),
      new Point(-1, 0)
  );

  public int minimumObstacles(int[][] grid) {
    final var seen = new HashSet<Point>();
    final var pq = new PriorityQueue<PointWeight>(Comparator.comparing(p -> p.weight));
    pq.add(new PointWeight(0, new Point(0, 0)));

    final var objective = new Point(grid.length -1, grid[0].length -1);

    return fillDp(grid, pq, seen, objective);
  }

  private int fillDp(int[][] grid, PriorityQueue<PointWeight> pq,
                     HashSet<Point> seen, Point objective) {


    while (!pq.peek().point.equals(objective)) {

      final var pw = pq.poll();
      final var point = pw.point;
      seen.add(point);
      final var weight = grid[point.row][point.col];

      MOVES.stream()
          .map(m -> new Point(m.row + point.row, m.col + point.col))
          .filter(m -> !seen.contains(m))
          .filter(m -> isValidPoint(grid, m))
          .forEach(m -> pq. add(new PointWeight(pw.weight + weight, m)));
    }


    return pq.peek().weight;
  }

  final boolean isValidPoint(int[][] grid, Point p) {
    try {
      return grid[p.row][p.col] >= 0;
    } catch (ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }

  private record PointWeight(int weight, Point point) {}

  private record Point(int row, int col) {}
}
