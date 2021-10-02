package exercises.number;

import java.util.Set;
import java.util.stream.IntStream;

public class IsUgly {
  public boolean isUgly(final int n) {
    if ( n < 4 ) return true;
    final var ugly = Set.of(
      2, 3, 5
    );

    return !IntStream.rangeClosed(4, n)
      .filter(i -> n % i == 0)
      .anyMatch(i -> !ugly.contains(i));
  }
}
