package exercises.array;

import java.util.Arrays;

public class MaxNumberOfPoints {
  public long maxPoints(int[][] points) {
    final var result = new int[points.length + 1][points[0].length];

    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j < points[i].length; j++) {
        final var element = points[i][j];
        for (int k = Math.max(0, j - 1); k < Math.min(points[i].length, j + 2); k++) {
          final int difference = Math.abs(k - j);
          result[i + 1][j] = Math.max(result[i + 1][j],
            result[i][k] + element - difference);
        }
      }
    }

    return Arrays.stream(result[points.length])
      .max()
      .orElse(0);
  }
}
