package exercises.array.array;

public class KthSmallestElement {
  public int kthSmallest(int[][] matrix, int k) {
    int row = matrix.length / (k-1);
    int col = k - row * matrix.length;

    return matrix[row][col];
  }
}
