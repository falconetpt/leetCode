package exercises.number;

import java.util.HashMap;

public class Tribon {
  public int tribonacci(int n) {
    if (n < 3) {
      return n == 0
        ? 0
        : 1;
    }

    return tribonacci(0, 1, 1, n - 2);
  }

  private int tribonacci(final int i, final int i1, final int i2, final int steps) {
    if (steps == 0) {
      return i2;
    } else {
      return tribonacci(i1, i2, i + i1 + i2, steps - 1);
    }
  }
}
