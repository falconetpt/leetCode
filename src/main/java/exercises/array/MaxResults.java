package exercises.array;

import java.util.stream.IntStream;

public class MaxResults {
  public int maxResult(final int[] nums, final int k) {
    final var result = new int[nums.length + 1];

    for (int i = nums.length - 1; i >= 0; i--) {
      final var element = nums[i];
      result[i] = IntStream.range(i, Math.min(i + k + 1, result.length))
        .map(x -> element + result[x])
        .max()
        .orElse(element);
    }

    return result[0];
  }
}
