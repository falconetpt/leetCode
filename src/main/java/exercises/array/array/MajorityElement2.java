package exercises.array.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>(  );
        } else {
            Arrays.sort(nums);
            return majorityElement( nums, nums[0], 1, 1, nums.length / 3,  new ArrayList<Integer>(  ) );
        }
    }

    private List<Integer> majorityElement(int[] nums,
                                          int num,
                                          int i,
                                          int count,
                                          int threshold,
                                          List<Integer> integers) {
        if ( i >= nums.length ) {
            if (count > threshold) integers.add( num );
            return integers;
        } else {
            int newNum = nums[i];
            if (newNum == num) {
                return majorityElement( nums, num, i + 1, count + 1, threshold, integers );
            } else {
                if (count > threshold) integers.add( num );
                return majorityElement( nums, newNum, i + 1, 1, threshold, integers );
            }
        }
    }

    /**
     * https://leetcode.com/problems/majority-element-ii/
     * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
     *
     * Note: The algorithm should run in linear time and in O(1) space.
     *
     * Example 1:
     *
     * Input: [3,2,3]
     * Output: [3]
     * Example 2:
     *
     * Input: [1,1,1,3,3,2,2,2]
     * Output: [1,2]
     */
}
