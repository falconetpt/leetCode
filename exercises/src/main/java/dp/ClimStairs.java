package dp;

public class ClimStairs {
  public int climbStairs(int n) {
    final var dp = new int[n + 2];
    dp[n-1] = 1;
    dp[n] = 1;


    for (int i = n - 2; i >= 0; i--) {
      dp[i] = dp[i + 1] + dp[i+2];
    }


    return dp[0];
  }
}
