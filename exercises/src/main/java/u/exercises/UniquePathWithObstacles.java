package u.exercises;

public class UniquePathWithObstacles {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    final var dp = new int[obstacleGrid.length][obstacleGrid[0].length];

    if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length - 1] == 1) return 0;
    dp[obstacleGrid.length-1][obstacleGrid[0].length - 1] = 1;

    expand(obstacleGrid, 0, 0, dp);

    return dp[0][0];
  }

  private int expand(int[][] obstacleGrid, int x, int y, int[][] dp) {
    if (x >= obstacleGrid.length || y >= obstacleGrid[x].length) return 0;
    if (dp[x][y] > 0) return dp[x][y];
    if (obstacleGrid[x][y] == 1) return dp[x][y];

    final var forward = expand(obstacleGrid, x, y +1, dp);
    final var down = expand(obstacleGrid, x + 1, y, dp);

    dp[x][y] = forward + down;

    return dp[x][y];
  }
}
