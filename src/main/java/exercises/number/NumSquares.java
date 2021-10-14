package exercises.number;

public class NumSquares {
  public int numSquares(final int n) {
    final var result = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      final var sqrt = (int) Math.sqrt(i);

      if (sqrt * sqrt == i) {
        result[i] = 1;
      } else {
        var localMin = Integer.MAX_VALUE;

        for (int j = 1; j <= i / 2; j++) {
          localMin = Math.min(result[j] + result[i - j], localMin);
        }
        result[i] = localMin;
      }
    }

    return result[n];
  }
}
