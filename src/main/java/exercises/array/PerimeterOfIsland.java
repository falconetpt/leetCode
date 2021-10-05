package exercises.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PerimeterOfIsland {
  public int islandPerimeter(final int[][] grid) {
    final var landCount = IntStream.range(0, grid.length)
      .map(i -> countOnes(grid[i]))
      .sum();

    return landCount < 2
      ? landCount * 4
      : 2 * 3 + 2 * (landCount - 2);
  }

  private int countOnes(final int[] ints) {
    return (int) Arrays.stream(ints)
      .filter(i -> i == 1)
      .count();
  }
}
