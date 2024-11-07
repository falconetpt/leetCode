package u.exercises;

import exercises.array.KClosestPoint;

import java.awt.*;

public class CountSubMatrices {
  public int countSubmatrices(int[][] grid, int k) {
    return fillDP(grid, k);
  }

  private static int fillDP(int[][] grid, int k) {
    // formula (x, y) + (x-1, y) + (x, y-1) - (x-1, y-1)
    final var dp = new int[grid.length + 1][grid[0].length + 1]; // +1 length to avoid checks on array out of bounds
    var count = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        final var currentPointX = i + 1;
        final var currentPointY = j + 1;

        final var element = grid[i][j]
            + dp[currentPointX - 1][currentPointY]
            + dp[currentPointX][currentPointY - 1]
            - dp[currentPointX - 1][currentPointY - 1];

        dp[currentPointX][currentPointY] = element;

        if (element > k) {
          break;
        } else {
          count++;
        }
      }
    }

    return count;
  }
}
