package exercises.array;

import java.util.Arrays;

public class ArrayPairSum {
  public int arrayPairSum(int[] nums) {
    Arrays.sort(nums);
    return sum(nums, 0, 0);
  }

  private int sum(final int[] nums, final int i, final int sum) {
    if (i >= nums.length) {
      return sum;
    } else {
      return sum(nums, i + 2, sum + nums[i]);
    }
  }
}
