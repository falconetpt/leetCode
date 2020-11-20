package exercises.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IntervalsOverlap {
    public int[][] merge(int[][] intervals) {
        List<int[]> sorted = Arrays.stream(intervals)
                .sorted( Comparator.comparingInt( a -> a[0] ) )
                .collect( Collectors.toList());
        List<int[]> result = new ArrayList<>(  );

        sorted.stream().reduce( (a, b) -> {
            if (b[0] >= a[0] && b[0] <= a[1]) {
                return new int[] {a[0], Math.max( b[1], a[1] )};
            } else {
                result.add( a );
                return b;
            }
        } ).ifPresent( result::add );

        int[][] output = new int[result.size()][2];
        result.toArray( output );

        return output;
    }
}
