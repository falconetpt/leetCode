package exercises.array.array;

import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxSubArrayProduct {
    public int maxProduct(int[] nums) {
        TreeSet<Integer> negativeNums = IntStream.range(0, nums.length).boxed()
                .filter( i -> nums[i] < 0 )
                .collect( Collectors.toCollection( TreeSet::new ) );

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int resultLocal = 1;

            for (int j = i; j < nums.length; j++) {
                resultLocal *= nums[j];
                result = Math.max( result, resultLocal );
            }
        }

        return result;
    }
}
