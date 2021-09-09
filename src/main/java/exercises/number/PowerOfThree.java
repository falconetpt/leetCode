package exercises.number;

public class PowerOfThree {
  public boolean isPowerOfThree(final int n) {
    final var log = Math.log10(n) / Math.log10(3);
    return Math.abs((int) log - log) < 0.0000000001;
  }
}
