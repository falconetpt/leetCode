package exercises.array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        return majorityElement( nums, new HashMap<Integer, Integer>(), 0 );
    }

    private int majorityElement(int[] nums,
                                Map<Integer, Integer> map,
                                int i) {
        if(i >= nums.length) {
            return -1;
        } else {
            int newValue = map.getOrDefault( nums[i], 0 ) + 1;
            map.put( nums[i], newValue);
            return newValue > nums.length / 2 ? nums[i] : majorityElement( nums, map, i + 1 );
        }
    }

    /**
     * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3321/
     *
     * Given an array of size n, find the majority element.
     * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
     *
     * You may assume that the array is non-empty and the majority element always exist in the array.
     *
     * Example 1:
     *
     * Input: [3,2,3]
     * Output: 3
     * Example 2:
     *
     * Input: [2,2,1,1,1,2,2]
     * Output: 2
     */
}
