package exercises.blind;

public class RotateImage {
  public void rotate(final int[][] matrix) {
    final var result = new int[matrix.length][matrix.length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        result[i][j] = matrix[matrix.length - 1 - j][i];
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        matrix[i][j] = result[i][j];
      }
    }
  }
}
