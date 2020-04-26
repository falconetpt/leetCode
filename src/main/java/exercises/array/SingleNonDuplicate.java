package exercises.array;

import java.util.Arrays;

public class SingleNonDuplicate {

    public int singleNonDuplicate(int[] nums) {
        return Arrays.stream(nums).reduce( 0, (a, b) -> a ^ b );
    }

    /**
     * You are given a sorted array consisting of only integers where every element appears exactly twice,
     * except for one element which appears exactly once. Find this single element that appears only once.
     *
     *
     *
     * Example 1:
     *
     * Input: [1,1,2,3,3,4,4,8,8]
     * Output: 2
     * Example 2:
     *
     * Input: [3,3,7,7,10,11,11]
     * Output: 10
     */
}
