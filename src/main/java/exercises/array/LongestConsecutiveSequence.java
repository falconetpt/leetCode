package exercises.array;

import java.util.Arrays;

public class LongestConsecutiveSequence {
  public int longestConsecutive(final int[] nums) {
    var conseq = 0;
    var max = 0;
    if(nums.length == 0) return 0;
    Arrays.sort(nums);

    for (int i = 1; i < nums.length; i++) {
      if (Math.abs(nums[i] - nums[i - 1]) > 1) {
        max = Math.max(max, conseq);
        conseq = 0;
      } else {
        if (Math.abs(nums[i] - nums[i - 1]) == 1) {
          conseq++;
        }
      }
    }

    return Math.max(max, conseq) + 1;
  }
}
