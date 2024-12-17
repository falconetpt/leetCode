package dp;

public class DiagonalTraversal {
  public int[] findDiagonalOrder(int[][] mat) {
    final var result = new int[mat.length * mat[0].length];
    var index = 0;

    for (int col = 0; col < mat[0].length; col++) {
      final var move = col % 2 == 0
        ? new int[] { -1, -1 }
        : new int[] { 1, 1};

      var point = col % 2 == 0
          ? new int[] { 0, col}
          : new int[] { mat.length - 1, 0 };

      do {
        result[index++] = mat[point[0]][point[1]];
        point[0] = point[0] + move[0];
        point[1] = point[1] + move[1];
      } while (isValid(point, mat));

    }

    return result;
  }

  private boolean isValid(int[] point, int[][] mat) {
    try {
      final var check = mat[point[0]][point[1]];
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
