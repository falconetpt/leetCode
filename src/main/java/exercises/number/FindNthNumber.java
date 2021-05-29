package exercises.number;

public class FindNthNumber {
  public int findNthDigit(final int n) {
    var i = 1;
    var remaining = n;

    while (String.valueOf(i).length() < remaining) {
      remaining -= String.valueOf(i).length();
      i += 1;
    }

    return Character
      .getNumericValue(String.valueOf(i).charAt(remaining - 1));
  }

  private int findNthDigit(final int i, final int n) {
    final var number = String.valueOf(i);

    if (number.length() >= n) {
      return Character.getNumericValue(number.charAt(n - 1));
    } else {
      return findNthDigit(i + 1, n - number.length());
    }
  }
}
