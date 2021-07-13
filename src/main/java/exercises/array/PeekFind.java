package exercises.array;

import java.util.stream.IntStream;

public class PeekFind {
  public int findPeakElement(int[] nums) {

    return IntStream.rangeClosed(0, nums.length)
      .filter(i -> isGreater(nums, i, i - 1) && isGreater(nums, i, i+1))
      .findFirst()
      .orElse(0);
  }

  private boolean isGreater(final int[] nums, final int i, final int i2) {
    try {
      return nums[i] > nums[i2];
    } catch (Exception e) {
      return true;
    }

  }
}
