package exercises.number;

public class ReverseNumber {
  public int reverse(final int x) {
    return reverse(x, 0);
  }

  private int reverse(final int x, final int total) {
    if (x == 0) {
      return total;
    } else {
      final var newValue = x % 10;
      return reverse(x / 10, total * 10 + newValue);
    }
  }
}
