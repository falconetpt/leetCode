package u.exercises;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaxSumArray {
  public int maxSum(int[] arr) {
    final var sum = IntStream.range(0, arr.length)
        .map(i -> i * arr[i])
        .sum();

    for (int i = 1; i < arr.length; i++) {
      final var prev = arr[i -1];

    }

    return 0;
  }
}
