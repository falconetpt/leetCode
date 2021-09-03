package exercises.array;

import java.math.BigInteger;

public class FirstBadVersion extends VersionControl {
  public int firstBadVersion(final int n) {
    return firstBadVersion(BigInteger.valueOf(1L), BigInteger.valueOf(n));
  }

  private int firstBadVersion(final BigInteger start, final BigInteger end) {
    final var middle = start.add(end).divide(BigInteger.TWO);

    if (isBadVersion(middle.intValue())) {
      return isBadVersion(middle.intValue() - 1)
        ? firstBadVersion(start, middle.subtract(BigInteger.ONE))
        : middle.intValue();
    } else {
      return firstBadVersion(middle.add(BigInteger.ONE), end);
    }
  }
}