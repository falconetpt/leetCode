package exercises.array;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class UglyNumber {
    public int nthUglyNumber(int n, int a, int b, int c) {
        Stream<Integer> iterable = Stream.iterate( 2, i -> i + 1 );
        Predicate<Integer> isUgly = (i) -> Stream.of( a, b, c ).anyMatch( num -> i % num == 0 );

        return iterable.filter( isUgly )
                .limit( n )
                .skip( n-1 )
                .findFirst()
                .orElse( -1 );
    }
}
