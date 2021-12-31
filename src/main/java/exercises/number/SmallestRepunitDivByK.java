package exercises.number;

import java.math.BigInteger;
import java.util.stream.Stream;

public class SmallestRepunitDivByK {
  public int smallestRepunitDivByK(final int k) {
    if (k % 2 == 0) return -1;
    final var divisor = BigInteger.valueOf(k);

    return Stream.iterate(BigInteger.ONE, i -> i.multiply(BigInteger.TEN).add(BigInteger.ONE))
      .filter(i -> i.mod(divisor).equals(BigInteger.ZERO))
      .limit(1)
      .map(BigInteger::toString)
      .map(String::length)
      .findFirst()
      .orElse(-1);
  }
}
