package exercises.blind;

import java.util.TreeMap;

public class LongestIncreasingSubsequence {
  public int lengthOfLIS(final int[] nums) {
    final var cache = new int[nums.length];
    var max = 0;


    for (int i = nums.length - 1; i >= 0; i--) {

      var next = 0;
      final var element = nums[i];

      for (int j = 0; j < cache.length; j++) {
        if (element < nums[j]) next = Math.max(cache[j], next);
      }

      cache[i] = next + 1;
      max = Math.max(cache[i], max);
    }

    return max;
  }
}
