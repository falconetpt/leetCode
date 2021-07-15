package exercises.number;

import java.util.stream.IntStream;

public class FindKthNumber {
  public int findKthNumber(int n, int k) {
    return IntStream.rangeClosed(1, n)
      .boxed()
      .map(String::valueOf)
      .sorted()
      .skip(k - 1)
      .map(Integer::parseInt)
      .findFirst()
      .orElse(-1);
  }
}
