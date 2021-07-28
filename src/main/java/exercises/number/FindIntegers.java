package exercises.number;

import java.util.HashMap;
import java.util.stream.IntStream;

public class FindIntegers {
  public int findIntegers(final int n) {
    final var cache = new HashMap<Integer, Boolean>();

    return (int) IntStream.rangeClosed(0, n)
      .filter(num -> nonConsecutiveBinary(num, 0, cache))
      .count();
  }

  private boolean nonConsecutiveBinary(final int num, final int previousNum, final HashMap<Integer, Boolean> cache) {
    if (num == 0) {
      return true;
    } else {
      final var remainder = num % 2;
      final var nextValue = num / 2;
      final var result = (remainder != 1 || previousNum != 1)
        && nonConsecutiveBinary(nextValue, remainder, cache);

      return result;
    }
  }
}
