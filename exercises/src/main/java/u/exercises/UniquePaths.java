package u.exercises;

public class UniquePaths {
  public int uniquePaths(int m, int n) {
    final var dp = new int[m][n];
    dp[m-1][n-1] = 1;

    uniquePaths(0, 0, dp);

    return dp[0][0];
  }

  private int uniquePaths(int x, int y, int[][] dp) {
    if (x >= dp.length || y >= dp[x].length) return 0;
    if (dp[x][y] > 0) {
      return dp[x][y];
    } else {
      final var forward = uniquePaths(x, y + 1, dp);
      final var bottom = uniquePaths(x + 1, y, dp);
      dp[x][y] = forward + bottom;
      //System.out.println(dp[x][y] + " - " + forward + " - " + bottom);

      return dp[x][y];
    }
  }
}
