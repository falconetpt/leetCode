package exercises.array;

public class MatrixReshape {
  public int[][] matrixReshape(int[][] mat, int r, int c) {
    final var rows = c / (r > 0 ? r : 1);
    final var result = new int[r][rows];
    var row = 0;
    var col = 0;

    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        if (col == rows) {
          col = 0;
          row++;
        }

        result[row][col] = mat[i][j];
        col++;
      }
    }

    return result;
  }
}
