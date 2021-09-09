package exercises.number;

import java.util.Arrays;
import java.util.stream.IntStream;

public class HammingWeight {
  public int hammingWeight(final int n) {
    final var array = Integer.toBinaryString(n).toCharArray();

    return (int) IntStream.range(0, array.length)
      .filter(i -> array[i] == '1')
      .count();
  }
}
