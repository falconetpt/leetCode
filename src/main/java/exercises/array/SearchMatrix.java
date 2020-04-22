package exercises.array;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        } else {
            int operation = Math.abs(target - matrix[0][0]) > Math.abs(target - matrix[matrix.length-1][matrix[0].length-1]) ? -1 : 1;
            int row = operation > 0 ? 0 : matrix.length-1;
            int col = operation > 0 ? 0 : matrix[0].length-1;
            BiPredicate<Integer, Integer> comparator = operation > 0 ? (a, b) -> a <= b : (a, b) -> a >= b;

            return searchElement(matrix, target, row, col, new HashMap<>(), operation, comparator);
        }
    }

    public boolean searchElement(int[][] matrix, int target, int row, int col, Map<String, Boolean> cache,
                                 int operation, BiPredicate<Integer, Integer> comparator) {
        if (isValidPosition(matrix, row, col)) {
            if (matrix[row][col] == target) {
                return true;
            } else {
                String key = row + ":" + col;
                if(!cache.containsKey(key)) {
                    int newRow = isValidPosition(matrix, row + operation, col)
                            && comparator.test(matrix[row+operation][col], target) ? row + operation : row;
                    int newColumn = isValidPosition(matrix, row, col + operation)
                            && comparator.test(matrix[row][col + operation], target) ? col + operation : col;

                    boolean searchRow = newRow != row && searchElement(matrix, target, newRow, col, cache, operation, comparator);
                    boolean searchCol = newColumn != col && searchElement(matrix, target, row, newColumn, cache, operation, comparator);

                    cache.putIfAbsent(key, searchCol || searchRow);
                }

                return cache.get(key);
            }
        } else {
            return false;
        }
    }

    private boolean isValidPosition(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length
                && col >= 0 && col < matrix[row].length;
    }

    /**
     * https://leetcode.com/problems/search-a-2d-matrix-ii/
     *
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
     *
     * Integers in each row are sorted in ascending from left to right.
     * Integers in each column are sorted in ascending from top to bottom.
     * Example:
     *
     * Consider the following matrix:
     *
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     * Given target = 5, return true.
     *
     * Given target = 20, return false.
     */
}
