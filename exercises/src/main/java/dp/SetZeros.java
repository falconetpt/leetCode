package dp;

import java.util.Arrays;
import java.util.HashSet;

public class SetZeros {
  public void setZeroes(int[][] matrix) {
    final var rows = new HashSet<Integer>();
    final var cols = new HashSet<Integer>();

    addRowsAndColumns(matrix, rows, cols);

    for (final var row : rows) Arrays.fill(matrix[row], 0);
    for (final var col : cols) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][col] = 0;
      }
    }

  }

  private static void addRowsAndColumns(int[][] matrix, HashSet<Integer> row, HashSet<Integer> col) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        final var element = matrix[i][j];
        if (element == 0) {
          row.add(i);
          col.add(j);
        }
      }
    }
  }
}
