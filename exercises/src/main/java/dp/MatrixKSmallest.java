package dp;

public class MatrixKSmallest {
  public int kthSmallest(int[][] matrix, int k) {
    if (matrix.length == 1 && matrix[0].length == 1) return matrix[0][0];
    final var rowIndex = Math.max(0, k / matrix.length);

    return matrix[rowIndex][k - (rowIndex * matrix.length) - 1];
  }
}
