package exercises.blind;

public class MaxSubArray {
  public int maxSubArray(final int[] nums) {
    var result = Integer.MIN_VALUE;
    var local = 0;

    for (int i = 0; i < nums.length; i++) {
      final var element = nums[i];
      local += element;

      result = Math.max(result, local);
      if (local < 0) {
        local = 0;
      }
    }

    return result;
  }
}
