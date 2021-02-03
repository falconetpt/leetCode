package exercises.number;

import java.util.stream.IntStream;

public class Count1s {
    public int hammingWeight(int n) {
        final String s = String.valueOf(n);
        return (int) IntStream.range( 0, s.length() )
                .filter( i -> '1' == s.charAt( i ) )
                .count();
    }
}
