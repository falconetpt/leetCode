package dp;

public class CanJump {
  public boolean canJump(int[] nums) {
    final boolean[] dp = new boolean[nums.length];
    dp[nums.length - 1] = true;
    var lastIndex = nums.length - 1;

    for(int i = nums.length - 2; i>= 0; i--) {
      dp[i] = i + nums[i] >= lastIndex;

      if (dp[i]) lastIndex = i;
    }

    return dp[0];
  }
}
