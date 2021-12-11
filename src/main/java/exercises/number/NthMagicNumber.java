package exercises.number;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NthMagicNumber {
  public int nthMagicalNumber(final int n, final int a, final int b) {
    return Stream.iterate(Math.min(a, b), i -> i + 1)
      .map(i -> i % 1000007)
      .filter(i -> i % a == 0 || i % b == 0)
      .limit(n)
      .collect(Collectors.toList())
      .get(n - 1);
  }
}
