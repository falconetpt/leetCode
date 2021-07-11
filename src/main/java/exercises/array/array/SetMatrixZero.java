package exercises.array.array;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        if (matrix.length > 0 && matrix[0].length > 0) {
            Set<Integer> rowsSeen = new HashSet<>();
            Set<Integer> colsSeen = new HashSet<>();

            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] == 0) {
                        rowsSeen.add(row);
                        colsSeen.add(col);
                    }
                }
            }

            rowsSeen.forEach(row -> expandZeroRow(matrix, row));
            colsSeen.forEach(col -> expandZeroCol(matrix, col));
        }
    }

    private void expandZeroCol(int[][] matrix, int col) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][col] = 0;
        }
    }

    private void expandZeroRow(int[][] matrix, int row) {
        for (int col = 0; col < matrix[row].length; col++) {
            matrix[row][col] = 0;
        }
    }
}
