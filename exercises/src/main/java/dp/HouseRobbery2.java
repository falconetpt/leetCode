package dp;

public class HouseRobbery2 {
  public int rob(int[] nums) {
    if (nums.length == 1) return nums[0];
    if (nums.length == 2) return Math.max(nums[0], nums[1]);
    final var dp = new int[nums.length + 2];
    dp[nums.length + 1] = -nums[0];

    for (int i = nums.length - 2; i >= 0; i--) {
      dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
    }

    dp[nums.length + 1] = 0;

    for (int i = nums.length - 1; i >= 1; i--) {
      dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
    }


    return Math.max(dp[0], dp[1]);
  }
}
