package dp;

public class MaxSubArrSum {
  public int maxSubArray(int[] nums) {
    var result = nums[0];
    var max = result;

    for (int i = 1; i < nums.length; i++) {
      final var element = nums[i];
      final var next = result + element;

      if (element >= next) {
        result = element;
      } else {
        result = next;
      }

      max = Math.max(result, max);
    }

    return max;
  }
}
