package exercises.array;

import java.math.BigInteger;

public class GuessNum {
  public int guessNumber(int n) {
    return guessNumber(BigInteger.ONE, new BigInteger(String.valueOf(n)));
  }

  public int guessNumber(final BigInteger start, final BigInteger end) {
    final var n = start.add(end).divide(BigInteger.TWO);
    final var nInt = n.intValue();
    final var guess = guess(nInt);
    if (guess == 0) {
      return nInt;
    } else if (guess == 1) {
      return guessNumber( n.add(BigInteger.ONE), end);
    } else {
      return guessNumber( start, n.subtract(BigInteger.ONE));
    }
  }

  public int guess(int num) {
    return 0;
  }
}
