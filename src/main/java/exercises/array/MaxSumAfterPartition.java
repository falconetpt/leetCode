package exercises.array;

import java.util.stream.IntStream;

public class MaxSumAfterPartition {
  public int maxSumAfterPartitioning(int[] arr, int k) {
    return IntStream.range(0, arr.length)
      .map(i -> getMax(i, arr, k))
      .sum();
  }

  private int getMax(final int i, final int[] arr, final int k) {
    return IntStream.range(i, Math.min(arr.length, i + k))
      .max()
      .orElse(Integer.MIN_VALUE);
  }
}
