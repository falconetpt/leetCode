package exercises.blind;

import java.util.Arrays;
import java.util.HashSet;

public class SetMatrixToZero {
  public void setZeroes(final int[][] matrix) {
    final var rows = new HashSet<Integer>();
    final var columns = new HashSet<Integer>();

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          rows.add(i);
          columns.add(j);
        }
      }
    }

    for (final var row : rows) {
      Arrays.fill(matrix[row], 0);
    }

    for (final var col : columns) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][col] = 0;
      }
    }
  }
}
