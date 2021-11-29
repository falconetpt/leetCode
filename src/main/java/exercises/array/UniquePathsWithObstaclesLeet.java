package exercises.array;

public class UniquePathsWithObstaclesLeet {
  public int uniquePathsWithObstacles(final int[][] obstacleGrid) {
    final var result = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
    result[obstacleGrid.length - 1][obstacleGrid[0].length - 1] = obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 0
      ? 1
      : 0;

    for (int i = obstacleGrid.length - 1; i >= 0; i--) {
      for (int j = obstacleGrid[i].length - 1; j >= 0; j--) {
        if (obstacleGrid[i][j] == 0 && result[i][j] == 0) {
          result[i][j] = result[i  + 1][j] + result[i][j + 1];
        }
      }
    }

    return result[0][0];
  }
}
