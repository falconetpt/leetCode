package exercises.string;

public class SmallestString {
  private final static char FIRST_CHAR = 'a';

  public String getSmallestString(int n, int k) {
    var count = n;
    var remaining = k;
    final var result = new StringBuilder();

    while (count > 0) {
      final var element = Math.min(26, remaining - count + 1);
      remaining -= element;
      result.append((char) (FIRST_CHAR + element - 1));
      count--;
    }

    return result.reverse()
      .toString();
  }
}
