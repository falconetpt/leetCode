package exercises.number;

import java.util.stream.IntStream;

public class GetMoneyAmount {
  public int getMoneyAmount(int n) {
    final var total = IntStream.rangeClosed(1, n)
      .sum();
    var start = 1;

    while ((start + 1) * 2 < total) {
      start++;
    }

    return getMoneyAmount(start, n);
  }

  private int getMoneyAmount(final int start, final int end) {
    if (start >= end) {
      return 0;
    } else {
      return start
        + getMoneyAmount((start + 1 + end) / 2, end);
    }
  }
}
