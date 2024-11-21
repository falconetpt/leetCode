package dp;

public class MinPathSum {
  public int minPathSum(int[][] grid) {
    final var dp = new int[grid.length][grid[0].length];
    final var lastElement = grid[grid.length - 1][grid[0].length - 1];

    fillDP(dp, grid, 0, 0);


    return dp[0][0];
  }

  private int fillDP(int[][] dp, int[][] grid, int x, int y) {
    if (x >= dp.length || y >= dp[x].length) return Integer.MAX_VALUE;
    if (dp[x][y] > 0) return dp[x][y];

    final var right = fillDP(dp, grid, x + 1, y);
    final var down = fillDP(dp, grid, x, y + 1);

    final var addition = Math.min(right, down) == Integer.MAX_VALUE
        ? 0
        : Math.min(right, down);
    final var value = grid[x][y] + addition;

    dp[x][y] = value;


    return value;
  }
}
