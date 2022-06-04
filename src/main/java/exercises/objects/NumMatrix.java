package exercises.objects;

import java.util.stream.IntStream;

public class NumMatrix {

  private int[][] matrix;
  private int[][] orginalMatrix;

  public NumMatrix(int[][] matrix) {
    orginalMatrix = matrix;
    fillMatrix(matrix);
  }

  private void fillMatrix(final int[][] input) {
    this.matrix = new int[input.length][input[0].length];
    var count = 0;

    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j < input[i].length; j++) {
        count += input[i][j];
        matrix[i][j] = count;
      }
    }

  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return IntStream.rangeClosed(row1, row2)
      .map(i -> matrix[i][col2] - matrix[i][col1] + orginalMatrix[i][col1])
      .reduce(0, Integer::sum);
  }
}
