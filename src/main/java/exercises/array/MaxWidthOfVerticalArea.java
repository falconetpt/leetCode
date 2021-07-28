package exercises.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class MaxWidthOfVerticalArea {
  public int maxWidthOfVerticalArea(int[][] points) {
    Arrays.sort(points, Comparator.comparing(x -> x[0]));

    return IntStream.range(1, points.length)
      .map(i -> points[i][0] - points[i - 1][0])
      .max()
      .orElse(0);
  }
}
