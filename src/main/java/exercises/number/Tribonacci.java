package exercises.number;

public class Tribonacci {
  public int tribonacci(final int n) {
    if (n == 0) return 0;

    return tribonacci(n - 1, 0, 0, 1);
  }

  private int tribonacci(final int n, final int i, final int i1, final int i2) {
    if (n == 0) {
      return i2;
    } else {
      return tribonacci(n - 1, i1, i2, i + i1 + i2);
    }
  }
}
