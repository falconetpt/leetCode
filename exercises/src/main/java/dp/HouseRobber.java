package dp;

public class HouseRobber {
  public int rob(int[] nums) {
    final var dp = new int[nums.length + 2];

    for (int i = nums.length - 1; i >= 0; i--) {
      dp[i] = Math.max(dp[i+1], nums[i] + dp[i + 2]);
    }

    return Math.max(dp[0], dp[1]);
  }
}
