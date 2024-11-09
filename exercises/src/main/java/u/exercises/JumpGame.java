package u.exercises;

import java.util.stream.IntStream;

public class JumpGame {
  public boolean canJump(int[] nums) {
    final var dp = new boolean[nums.length];
    dp[nums.length - 1] = true;

    for (int i = nums.length -2; i >= 0; i--) {
      final var jumps = nums[i];
      dp[i] = IntStream.rangeClosed(i + 1, Math.min(nums.length -1, i + jumps))
          .anyMatch(x -> {
            //System.out.println(jumps + ":" + x);
            return dp[x];
          });
      //System.out.println(dp[i]);
    }

    return dp[0];
  }
}
