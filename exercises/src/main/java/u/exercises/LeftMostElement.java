package u.exercises;

public class LeftMostElement {
  public int leftMostElement(int[][] matrix) {
    var result = Integer.MAX_VALUE;


    for (int i = 0; i < matrix.length; i++) {
      final var row = matrix[i];
      result = Math.min(binarySearch(row, 0, matrix.length), result);
    }


    return result == Integer.MAX_VALUE
        ? -1
        : result;
  }

  private int binarySearch(int[] row, int start, int end) {
    if (start >= end) {
      return Integer.MAX_VALUE;
    } else {
      int index = (start + end) / 2;
      final var element = row[index];

      if (element == 1) {
        return Math.min(binarySearch(row, start, index), index);
      } else {
        return binarySearch(row, index + 1, end);
      }
    }
  }
}
