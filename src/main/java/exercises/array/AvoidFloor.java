package exercises.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AvoidFloor {
    public int[] avoidFlood(final int[] rains) {
        Set<Integer> set = Arrays.stream( rains ).boxed().collect( Collectors.toSet());
        int[] result = new int[rains.length];

        if (set.size() == rains.length) {
            IntStream.range( 0, result.length ).forEach( i -> result[i] = -1 );
            return result;
        } else {
            return new int[] {};
        }
    }
}
