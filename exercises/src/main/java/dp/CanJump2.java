package dp;

public class CanJump2 {
  public int jump(int[] nums) {
    final var dp = new int[nums.length];

    for (int i = nums.length - 2; i >= 0; i--) {
      final var jumps = nums[i];
      dp[i] = nums.length;
      for (int j = i + 1; j < Math.min(jumps + i + 1, nums.length); j++) {
        dp[i] = Math.min(1 + dp[j], dp[i]);
      }

    }

    return dp[0];
  }
}
