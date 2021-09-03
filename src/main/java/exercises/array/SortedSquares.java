package exercises.array;

import java.util.Arrays;

public class SortedSquares {
  public int[] sortedSquares(final int[] nums) {
    return Arrays.stream(nums)
      .map(n -> n * n)
      .sorted()
      .toArray();
  }
}
