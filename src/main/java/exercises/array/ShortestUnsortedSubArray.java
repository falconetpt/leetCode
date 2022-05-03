package exercises.array;

import java.util.Arrays;

public class ShortestUnsortedSubArray {
  public int findUnsortedSubarray(final int[] nums) {
    final var sorted = Arrays.copyOf(nums, nums.length);
    Arrays.sort(sorted);
    var end = sorted.length - 1;
    var start = 0;

    while (start < end) {
      if (nums[start] == sorted[start]) {
        start++;
      } else if (nums[end] == sorted[end]) {
        end--;
      } else {
        return end - start + 1;
      }

    }

    return end - start;
  }
}
