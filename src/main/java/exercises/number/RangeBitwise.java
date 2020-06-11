package exercises.number;

import java.util.stream.IntStream;

public class RangeBitwise {
    public int rangeBitwiseAnd(int m, int n) {
        return IntStream.range(m, n).reduce( (a, b) -> a & b).orElse( 0 );
    }
}
