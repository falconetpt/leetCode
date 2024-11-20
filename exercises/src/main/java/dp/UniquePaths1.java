package dp;

public class UniquePaths1 {
  public int uniquePaths(int m, int n) {
    final var dp = new int[m][n];
    dp[m - 1][n - 1] = 1;

    uniquePaths(dp, 0, 0);

    return dp[0][0];
  }

  private int uniquePaths(int[][] dp, int x, int y) {
    if (x >= dp.length || y >= dp[x].length) return 0;
    if (dp[x][y] > 0) return dp[x][y];

    dp[x][y] = uniquePaths(dp, x + 1, y) + uniquePaths(dp, x, y + 1);

    return dp[x][y];
  }
}
