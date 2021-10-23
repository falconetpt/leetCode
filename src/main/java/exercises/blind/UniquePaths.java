package exercises.blind;

public class UniquePaths {
  public int uniquePaths(final int m, final int n) {
    final var arr = new int[m + 1][n + 1];
    arr[1][0] = 1;

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        arr[i][j] = arr[i-1][j] + arr[i][j-1];
      }
    }

    return arr[m][n];
  }
}
