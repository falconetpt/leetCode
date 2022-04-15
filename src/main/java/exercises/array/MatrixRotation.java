package exercises.array;

import java.awt.*;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixRotation {
  public int[][] generateMatrix(final int n) {
    final var matrix = new int[n][n];
    final var order = Stream.of(
      new Point(0, 1),
      new Point(1, 0),
      new Point(0, -1),
      new Point(-1, 0)
    ).collect(Collectors.toCollection(LinkedList::new));

    return generateMatrix(matrix, order, new Point(0, -1), 1);
  }

  private int[][] generateMatrix(final int[][] matrix,
                                 final LinkedList<Point> order,
                                 final Point point,
                                 final int i) {
    if (i > matrix.length * matrix.length) {
      return matrix;
    } else {
      final var delta = order.peekFirst();
      final var newPoint = new Point(point.x + delta.x, point.y + delta.y);

      if (isValid(matrix, newPoint)) {
        matrix[newPoint.x][newPoint.y] = i;
        generateMatrix(matrix, order, newPoint, i + 1);
      } else {
        order.addLast(order.pollFirst());
        generateMatrix(matrix, order, point, i);
      }

      return matrix;
    }
  }

  private boolean isValid(final int[][] matrix, final Point point) {
    try {
      return matrix[point.x][point.y] == 0;
    } catch (final IndexOutOfBoundsException e) {
      return false;
    }
  }
}
