package exercises.array;

import java.util.Arrays;
import java.util.stream.Stream;

public class MinFallingPathSumDec {
  public int minFallingPathSum(final int[][] matrix) {
    final var result = new int[matrix.length][matrix[0].length];
    fillFirstLine(matrix, result);

    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[i].length; j++) {
        result[i][j] = matrix[i][j]
          + Stream.of(
            getValue(matrix, i - 1, j),
           getValue(matrix, i - 1, j + 1),
           getValue(matrix, i - 1, j - 1)
          ).min(Integer::compareTo)
          .orElse(0);
      }
    }

    return Arrays.stream(result[matrix.length -1])
      .min()
      .orElse(-1);
  }

  private int getValue(final int[][] matrix, final int i, final int j) {
    try {
      return matrix[i][j];
    } catch (final Exception e) {
      return Integer.MAX_VALUE;
    }
  }

  private void fillFirstLine(final int[][] matrix, final int[][] result) {
    for (int i = 0; i < matrix[0].length; i++) {
      result[0][i] = matrix[0][i];
    }
  }
}
