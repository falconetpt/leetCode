package finalPrep;

import java.util.stream.IntStream;

public class DefuseBomb {
  public int[] decrypt(int[] code, int k) {
    final var result = new int[code.length];

    if (k == 0) return result;

    var sum = IntStream.range(0, k)
        .map(i -> code[i % code.length])
        .sum();

    result[0] = sum;

    for (int i = 1; i < code.length; i++) {
      final var nextElement = code[(k + i - 1) % code.length];
      final var prevValue = code[(i - 1) % code.length];

      sum += nextElement - prevValue;

      result[i] = sum;
    }

    return result;
  }
}
