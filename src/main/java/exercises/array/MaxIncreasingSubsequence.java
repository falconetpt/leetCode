package exercises.array;

import java.util.TreeMap;

public class MaxIncreasingSubsequence {
  public int findNumberOfLIS(final int[] nums) {
    final var result = new int[nums.length];

    for (int i = nums.length - 1; i >= 0 ; i--) {
      result[i] = 0;
      for (int j = 0; j < nums.length; j++) {
        if (nums[i] < nums[j]) result[i] = Math.max(result[j] + 1, result[i]);
      }
    }

    return result[0];
  }
}
