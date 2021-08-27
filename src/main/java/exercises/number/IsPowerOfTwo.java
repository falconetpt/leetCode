package exercises.number;

public class IsPowerOfTwo {
  public boolean isPowerOfTwo(int n) {
    if (n==0) return false;
    final var log = (int) (Math.log(n) / Math.log(2));
    return Math.abs(Math.pow(2, log) - n) < 0.00001;
  }
}
