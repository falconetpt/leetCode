package dp;

public class CanJump {
  public boolean canJump(int[] nums) {
    final boolean[] dp = new boolean[nums.length];
    dp[nums.length - 1] = true;

    for(int i = nums.length - 2; i>= 0; i--) {
      dp[i] = false;
      for(int j = i + 1; j < Math.min(i + nums[i] + 1, nums.length); j++) {
        dp[i] = dp[i] || dp[j];
        if(dp[i]) break;
      }
    }

    return dp[0];
  }
}
