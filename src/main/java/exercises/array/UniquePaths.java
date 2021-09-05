package exercises.array;

import java.awt.Point;
import java.util.List;

public class UniquePaths {
  private static final List<Point> MOVES = List.of(
    new Point(0, 1),
    new Point(1, 0)
  );

  public int uniquePaths(int m, int n) {
    final var moves = new int[m][n];
    moves[m - 1][n - 1] = 1;

    calculateMoves(moves, new Point(0, 0));

    return moves[0][0];
  }

  private int calculateMoves(final int[][] moves, final Point point) {
    if (validPoint(point, moves)) {
      return 0;
    } else if (moves[point.x][point.y] > 0) {
      return moves[point.x][point.y];
    } else {
      moves[point.x][point.y] = MOVES.stream()
        .map(p -> new Point(point.x + p.x, point.y + p.y))
        .map(p -> calculateMoves(moves, p))
        .reduce(0, Integer::sum);

      return moves[point.x][point.y];
    }
  }

  private boolean validPoint(final Point point, final int[][] moves) {
    try {
      final var x = moves[point.x][point.y];
      return true;
    } catch (ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }
}
