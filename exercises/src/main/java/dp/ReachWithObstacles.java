package dp;

public class ReachWithObstacles {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    final var dp = new int[obstacleGrid.length][obstacleGrid[0].length];
    final var lastElement = obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1] = 1;

    if (lastElement == 1) return 0;

    uniquePathsWithObstacles(obstacleGrid, dp, 0, 0);
    return dp[0][0];
  }

  private int uniquePathsWithObstacles(int[][] obstacleGrid, int[][] dp, int x, int y) {
    if (x >= dp.length || y >= dp[x].length) return 0;
    if (dp[x][y] > 0) return dp[x][y];
    if (obstacleGrid[x][y] == 1) return 0;

    dp[x][y] = uniquePathsWithObstacles(obstacleGrid, dp, x + 1, y)
        + uniquePathsWithObstacles(obstacleGrid, dp, x, y + 1);

    return dp[x][y];
  }
}
