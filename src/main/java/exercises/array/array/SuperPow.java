package exercises.array.array;

import java.math.BigInteger;
import java.util.Arrays;

public class SuperPow {

    public int superPow(int a, int[] b) {
        String value = Arrays.stream(b).boxed().map( String::valueOf ).reduce( "", String::concat );
        return BigInteger.valueOf( a )
                .modPow( new BigInteger( value ), BigInteger.valueOf( 1337 ) )
                .intValue();
    }
}

