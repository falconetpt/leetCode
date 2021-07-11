package exercises.array.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SubArrDivisibleBy {
    public int subarraysDivByK(final int[] A, final int K) {
        if(A == null || A.length == 0) {
            return 0;
        } else {
            return subarraysDivByK(A, 0, A.length-1, K,
                    new HashSet<>(  ), Arrays.stream(A).sum() );
        }
    }

    public int subarraysDivByK(final int[] arr,
                               final int start,
                               final int end,
                               final int divisor,
                               final Set<String> seen,
                               final int value) {
        final String key = start + ":" + end;
        if(start > end || seen.contains( key )) {
            return 0;
        } else {
            seen.add( key );
            int isDivisible = value % divisor == 0 ? 1 : 0;

            if(start == end) {
                return isDivisible;
            } else {
                return isDivisible
                        + subarraysDivByK( arr, start + 1, end, divisor,
                                seen, value - arr[start] )
                        + subarraysDivByK( arr, start, end - 1, divisor,
                                seen, value - arr[end] );
            }

        }
    }
}
