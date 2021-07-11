package exercises.array.array;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class TwoNumberSum {
    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> numberLastIndex = new HashMap<>(  );

        // O (n) time | O(n) space
        IntStream.range( 0, nums.length )
                .forEach( i -> numberLastIndex.put( nums[i], i )  );

        // O(n) time
        return IntStream.range( 0, nums.length ).boxed()
                .filter( i -> !i.equals( numberLastIndex.getOrDefault( target - nums[i], i ) ) )
                .map( i -> new int[] { i, numberLastIndex.getOrDefault( target - nums[i], i ) } )
                .findFirst()
                .orElse( new int[] {} );
    }
}
