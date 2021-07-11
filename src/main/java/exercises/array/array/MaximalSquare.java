package exercises.array.array;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int result = 0;

        for (int i = 0; i < matrix.length - result / Math.max(result, 1); i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == '1') {
                    result = Math.max(result, expandRange(matrix, i, j));
                }
            }
        }

        return result;
    }

    private int expandRange(char[][] matrix, int row, int col) {
        boolean keepUp = true;
        int hop = 1;

        while (keepUp) {
            for (int i = row; i <= row + hop; i++) {
                for (int j = col; j <= col + hop; j++) {
                    try {
                        if (matrix[i][j] == '0') keepUp = false;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        keepUp = false;
                    }
                }
            }

            hop++;
        }

        return (hop - 1) * (hop - 1);
    }
}
