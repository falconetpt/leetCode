package u.exercises;

public class BustBalloons {
  public int maxCoins(int[] nums) {
    int[][] dp = new int[nums.length][nums.length];

    return calculateMax(nums, 0, nums.length, dp);
  }

  private int calculateMax(int[] nums, int start, int end, int[][] dp) {
    if (start > end) return 0;
    if (dp[start][end] != 0) return dp[start][end-1];

    var max = 0;

    for (int i = start; i <= end; i++) {
      final var prevValue = getValue(nums, i - 1);
      final var currentValue = getValue(nums, i);
      final var nextValue = getValue(nums, i + 1);

      int val = calculateMax(nums, start, i - 1, dp) +
          prevValue * currentValue * nextValue +
          calculateMax(nums, i + 1, end, dp);

      max = Math.max(max, val);
    }

    dp[start][end] = max;

    return dp[start][end];
  }


  private int getValue(int[] nums, int col) {
    if (col == -1 || col == nums.length) return 1;
    return nums[col];
  }
}
