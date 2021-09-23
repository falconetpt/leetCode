package exercises.array;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class UniquePathsWithObstacles {
  private static final List<Point> MOVES = List.of(
    new Point(-1, 0),
    new Point(0, -1)
  );

  private static final List<Point> SUM_MOVES = List.of(
    new Point(1, 0),
    new Point(0, 1)
  );

  public int uniquePathsWithObstacles(final int[][] obstacleGrid) {
    final var row = obstacleGrid.length - 1;
    final var col = obstacleGrid[0].length - 1;
    final var resultGrid = new int[row + 1][col + 1];
    final var queues = new LinkedList<Point>();
    resultGrid[row][col] = obstacleGrid[row][col] == 1
      ? 0
      : 1;

    MOVES.stream()
      .map(p -> new Point(row + p.x, col + p.y))
      .filter(p -> validPoints(obstacleGrid, p))
      .forEach(queues::addLast);

    while (!queues.isEmpty()) {
      final var element = queues.pollFirst();

      MOVES.stream()
        .map(p -> new Point(element.x + p.x, element.y + p.y))
        .filter(p -> validPoints(obstacleGrid, p))
        .filter(p -> resultGrid[p.x][p.y] != 0)
        .forEach(queues::addLast);

      resultGrid[element.x][element.y] = SUM_MOVES.stream()
        .map(p -> new Point(element.x + p.x, element.y + p.y))
        .filter(p -> validPoints(obstacleGrid, p))
        .map(p -> resultGrid[p.x][p.y])
        .reduce(0, Integer::sum);
    }

    return resultGrid[0][0];
  }

  private boolean validPoints(final int[][] obstacleGrid, final Point p) {
    try {
      return obstacleGrid[p.x][p.y] == 0;
    } catch (final IndexOutOfBoundsException e) {
      return false;
    }
  }
}
