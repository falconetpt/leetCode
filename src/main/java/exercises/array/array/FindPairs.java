package exercises.array.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindPairs {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Set<Integer>> frequency = new HashMap<>(  );
        IntStream.range( 0, nums.length )
                .peek( i -> frequency.putIfAbsent( nums[i], new HashSet<>(  ) ))
                .forEach( i -> frequency.get( nums[i] ).add( i ) );
        // O(N)

        return (int) frequency.keySet().stream()
                .flatMap( num -> Stream.of( num - k, num + k ) )
                .filter( n -> n / 2 == k && k * 2 == n ? frequency.getOrDefault( n, new HashSet<>(  ) ).size() > 1 : true )
                .filter( frequency::containsKey )
                .count();
    }
}
