package exercises.blind;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberOfBits {
  private static final List<Integer> FIRST_ELEMENTS = List.of(
    0,
    1,
    1
  );

  public int[] countBits(final int n) {
    final var result = new int[n + 1];
    IntStream.range(0, Math.min(result.length, FIRST_ELEMENTS.size()))
      .forEach(i -> result[i] = FIRST_ELEMENTS.get(i));

    for (int i = 3; i <= n; i++) {
      if (((i-1) & i) == 0) {
        result[i] = 1;
      } else if (i % 2 == 0) {
        result[i] = Stream.iterate(i, x -> x > 0, x -> x / 2)
          .map(x -> result[x])
          .reduce(0, Integer::sum);
      } else {
        result[i] = result[i - 1] + 1;
      }
    }

    return result;
  }
}
