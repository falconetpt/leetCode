package exercises.array.array;


import java.util.Arrays;
import java.util.Comparator;

public class KClosest {
    public int[][] kClosest(int[][] points, int K) {
        return Arrays.stream(points)
                .sorted( Comparator.comparing( a -> eucladianDistance( a[0], a[1] ) ) )
                .limit( K )
                .toArray(int[][]::new);
    }

    private Integer eucladianDistance(int x, int y) {
        return (int) (Math.pow( x, 2 ) + Math.pow( y, 2 ));
    }
}
