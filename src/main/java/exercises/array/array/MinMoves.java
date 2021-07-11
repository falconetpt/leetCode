package exercises.array.array;

import java.util.Arrays;

public class MinMoves {
  public int minMoves2(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    final var average = Arrays.stream(nums)
      .sorted()
      .toArray()[(nums.length-1) / 2];

    return Arrays.stream(nums)
      .map(i -> Math.abs(average - i))
      .sum();
  }
}
