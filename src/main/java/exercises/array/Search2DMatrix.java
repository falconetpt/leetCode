package exercises.array;

import java.util.stream.IntStream;

public class Search2DMatrix {
    public boolean searchMatrix(final int[][] matrix, final int target) {
        return searchMatrix( matrix, target, 0);
    }

    private boolean searchMatrix(final int[][] matrix, final int target,
                                 final int x) {
        if (x >= matrix.length || (matrix[x].length > 0 && matrix[x][0] > target)) {
            return false;
        } else {
            for (int i = 0; i < matrix[x].length; i++) {
                if (matrix[x][i] == target) return true;
            }

            return searchMatrix( matrix, target, x + 1 );
        }
    }
}
