package exercises.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinimumIncrementForUnique {
    public int minIncrementForUnique(int[] A) {
        if (A == null) {
            return 0;
        } else {
            Set<Integer> allNumbers = Arrays.stream( A ).boxed().collect( Collectors.toSet());
            // O(n log n)
            Arrays.sort( A );
            return minIncrementForUnique( A, 0, allNumbers, new HashSet<>(), 0 );
        }
    }

    private int minIncrementForUnique(int[] array,
                                      int i,
                                      Set<Integer> allNumbers,
                                      Set<Integer> seen,
                                      int result) {
        if (i >= array.length) {
            return result;
        } else {
            int num = array[i];

            if (seen.contains( num )) {
                int nextNum = Stream.iterate( num, n -> n + 1 )
                        .filter( n -> !seen.contains( n ) )
                        .limit( 1 )
                        .findFirst()
                        .orElse( num );
                seen.add( nextNum );

                return minIncrementForUnique( array, i + 1, allNumbers, seen, result + nextNum - num );
            } else {
                seen.add( num );
                return minIncrementForUnique( array, i + 1, allNumbers, seen, result );
            }
        }
    }
}
