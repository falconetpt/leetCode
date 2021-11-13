package exercises.blind;

import java.util.Arrays;

public class Rob2 {
  public int rob(final int[] nums) {
    if (nums.length < 4) return Arrays.stream(nums).max().orElse(0);
    final var result = new int[nums.length + 2];
    result[nums.length] = nums[0];

    for (int i = nums.length - 1; i >= 1; i--) {
      final var element = nums[i];
      result[i] = Math.max(result[i + 1], result[i + 2] + element);
    }

    return result[1];
  }
}
