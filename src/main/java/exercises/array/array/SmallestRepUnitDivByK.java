package exercises.array.array;

import java.math.BigInteger;
import java.util.stream.Stream;

public class SmallestRepUnitDivByK {
    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) {
            return -1;
        } else {
            return Stream.iterate( BigInteger.ONE,  i -> i.multiply( BigInteger.valueOf( 10L ) ).add( BigInteger.ONE ))
                    .filter( x -> x.remainder( BigInteger.valueOf( K ) ).intValue() == 0 )
                    .limit( 1 )
                    .map(BigInteger::toString)
                    .map(String::length)
                    .findFirst().orElse( -1 );
        }
    }
}
