package exercises.number;

import java.util.HashSet;

public class JudgeSquareSum {
  public boolean judgeSquareSum(int c) {
    final var set = new HashSet<Integer>();

    for (int i = 0; i <= Math.sqrt(c); i++) {
      final var dif = c - i * i;
      set.add(i * i);
      if (set.contains(dif)) return true;

    }

    return false;
  }
}
