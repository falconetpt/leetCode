package exercises.blind;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingNumber {
  public int missingNumber(final int[] nums) {
    final var sum = IntStream.rangeClosed(0, nums.length)
      .reduce(0, (a, b) -> a | b);

    return Arrays.stream(nums)
      .reduce(sum, (a, b) -> a ^ b);
  }
}
