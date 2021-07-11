package exercises.array;

import java.util.stream.IntStream;

public class ZeroSum {
  public int[] sumZero(final int n) {
    final var result = new int[n];

    fillArray(result, 1, 0);

    if (result.length % 2 != 0) result[result.length - 1] = 0;

    return result;
  }

  private void fillArray(final int[] result, final int value, final int i) {
    if (i < result.length - 1) {
      result[i] = value;
      result[i + 1] = -value;
      fillArray(result, value + 1, i + 2);
    }
  }
}
