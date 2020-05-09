package exercises.array;

import java.awt.*;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountSquares {
    public int countSquares(int[][] matrix) {
        LinkedList<Point> points = IntStream.range( 0, matrix.length ).boxed().flatMap(
                r -> IntStream.range( 0, matrix[r].length ).boxed().filter( c -> matrix[r][c] == 1)
                        .map( c  -> new Point(r, c) )
        ).collect( Collectors.toCollection( LinkedList::new ));

        return countSquares( matrix, points );
    }

    private int countSquares(int[][] matrix, LinkedList<Point> points) {
        if (points.isEmpty()) {
            return 0;
        } else {
            Point point = points.pollFirst();
            return 1 + expandPoint(matrix, point.x, point.y, point.x + 1, point.y + 1) + countSquares( matrix, points );
        }
    }

    private int expandPoint(int[][] matrix, int startRow, int startCol, int row, int col) {
        boolean valid = true;

        for (int r = startRow; r <= row && valid; r++) {
            try {
                valid = matrix[r][col] == 1;
            } catch (IndexOutOfBoundsException e) {
                valid = false;
            }
        }

        for (int c = startCol; c <= col && valid; c++) {
            try {
                valid = matrix[row][c] == 1;
            } catch (IndexOutOfBoundsException e) {
                valid = false;
            }
        }

        return valid ? 1 + expandPoint( matrix, startRow, startCol, row + 1, col + 1 ) : 0;
    }


    /**
     * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
     *
     * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
     *
     *
     *
     * Example 1:
     *
     * Input: matrix =
     * [
     *   [0,1,1,1],
     *   [1,1,1,1],
     *   [0,1,1,1]
     * ]
     * Output: 15
     * Explanation:
     * There are 10 squares of side 1.
     * There are 4 squares of side 2.
     * There is  1 square of side 3.
     * Total number of squares = 10 + 4 + 1 = 15.
     * Example 2:
     *
     * Input: matrix =
     * [
     *   [1,0,1],
     *   [1,1,0],
     *   [1,1,0]
     * ]
     * Output: 7
     * Explanation:
     * There are 6 squares of side 1.
     * There is 1 square of side 2.
     * Total number of squares = 6 + 1 = 7.
     *
     *
     * Constraints:
     *
     * 1 <= arr.length <= 300
     * 1 <= arr[0].length <= 300
     * 0 <= arr[i][j] <= 1
     *
     */
}
