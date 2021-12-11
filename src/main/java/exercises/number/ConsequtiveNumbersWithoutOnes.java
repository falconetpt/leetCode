package exercises.number;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ConsequtiveNumbersWithoutOnes {
  private Map<Integer, Boolean> CACHE = new HashMap<>();

  public int findIntegers(final int n) {
    return (int) IntStream.rangeClosed(0, n)
      .filter(i -> !hasConsecutiveOnes(i, 0))
      .count();
  }

  private boolean hasConsecutiveOnes(int n, int last) {
    if (n == 0) {
      return false;
    } else {
      final var remainder = n % 2;

      if (remainder == 1 && last == 1) {
        return true;
      } else {
        return hasConsecutiveOnes(n / 2, remainder);
      }
    }
  }
}
