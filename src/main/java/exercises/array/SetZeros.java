package exercises.array;

import java.awt.Point;
import java.util.HashSet;

public class SetZeros {
  public void setZeroes(final int[][] matrix) {
    final var set = new HashSet<Point>();

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          set.add(new Point(i, j));
        }
      }
    }

    set.forEach(p -> updateMatrix(matrix, p));

  }

  private void updateMatrix(final int[][] matrix, final Point p) {
    for (int i = 0; i < matrix[p.x].length; i++) {
      matrix[p.x][i] = 0;
    }

    for (int i = 0; i < matrix.length; i++) {
      matrix[i][p.y] = 0;
    }
  }
}
