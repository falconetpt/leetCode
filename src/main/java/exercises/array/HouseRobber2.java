package exercises.array;

import java.util.Arrays;

public class HouseRobber2 {
  public int rob(final int[] nums) {
    final var result = new int[nums.length];
    result[1] = nums[0];

    for (int i = 1; i < nums.length - 1; i++) {
      final var index = i + 1;
      result[index] = Math.max(
        result[index - 2] + nums[i],
        result[index - 1]
      );
    }

    final var result2 = new int[nums.length];
    result2[1] = nums[1];

    for (int i = 2; i < nums.length -1; i++) {
      final var index = i + 1;
      result2[index] = Math.max(
        result2[index - 2] + nums[i],
        result2[index - 1]
      );
    }

    return Math.max(result[nums.length - 1], result2[nums.length - 1]);
  }
}
