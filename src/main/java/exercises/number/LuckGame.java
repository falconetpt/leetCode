package exercises.number;

import java.util.stream.IntStream;

public class LuckGame {
  public boolean divisorGame(int n) {
    return divisorGame(n, true);
  }

  private boolean divisorGame(final int n, final boolean b) {
    return IntStream.range(1, n)
      .filter(i -> n % i == 0)
      .anyMatch(i -> divisorGame(n - i, !b) == !b);
  }
}
