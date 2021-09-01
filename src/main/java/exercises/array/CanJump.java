package exercises.array;

import java.util.stream.IntStream;

public class CanJump {
  public boolean canJump(final int[] nums) {
    final var canReachEndArray = new boolean[nums.length];
    canReachEndArray[nums.length - 1] = true;

    for (int i = nums.length - 2; i >= 0; i--) {
      canReachEndArray[i] = IntStream.rangeClosed(i + 1, Math.min(i + nums[i], nums.length - 1))
        .anyMatch(x -> canReachEndArray[x]);
    }

    return canReachEndArray[0];
  }
}
