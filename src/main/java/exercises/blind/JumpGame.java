package exercises.blind;

import java.util.stream.IntStream;

public class JumpGame {
  public boolean canJump(final int[] nums) {
    final var result = new boolean[nums.length];
    result[nums.length - 1] = true;

    for (int i = nums.length - 2; i >= 0; i--) {
      result[i] = IntStream.range(i + 1,  Math.min(nums[i] + i + 1, nums.length))
        .anyMatch(x -> result[x]);
    }

    return result[0];
  }
}
