package exercises.number;

public class ArrangeCoins {
  public int arrangeCoins(final int n) {
    return arrangeCoins(n, 1);
  }

  private int arrangeCoins(final int n, final int i) {
    if (n < i) {
      return 0;
    } else {
      return arrangeCoins(n - i, i + 1);
    }
  }
}
