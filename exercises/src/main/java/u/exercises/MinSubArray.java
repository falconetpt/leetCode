package u.exercises;

import java.util.Arrays;

public class MinSubArray {
  public int minSubarray(int[] nums, int p) {
    final var sum = Arrays.stream(nums).sum();

    if (sum == p) {
      return 0;
    }

    if (sum < p) {
      return -1;
    }

    return removeSubArr(nums, sum, p);
  }

  private int removeSubArr(int[] nums, int sum, int p) {
    final var delta = sum - p;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == delta) {
        return 1;
      }
    }

    return -1;
  }
}
