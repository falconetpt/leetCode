package exercises.array;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class NumMatrix {
    private int[][] matrix;
    private Map<String, Integer> cache;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix.clone();
        this.cache = new HashMap<>();
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return IntStream.rangeClosed( row1, row2 )
                .map( r -> sumRegionRec( r, col1, col2 ) )
                .reduce( 0, Integer::sum );
    }

    public int sumRegionRec(int row, int col1, int col2) {
        if ( col1 > col2) {
            return 0;
        }

        String key = row + ":" + col1 + ":" + col2;

        if (cache.containsKey( key )) {
            return cache.get( key );
        } else {
            int value = matrix[row][col1] + sumRegionRec( row, col1 + 1, col2 );
            cache.putIfAbsent( key, value );
            return value;
        }
    }
}
