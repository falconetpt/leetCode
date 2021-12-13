package exercises.string;

public class MaxPower {
  public int maxPower(final String s) {
    var prevChar = ' ';
    var count = 0;
    var max = 0;

    for (int i = 0; i < s.length(); i++) {
      final var element = s.charAt(i);

      if (element == prevChar) {
        count++;
      } else {
        max = Math.max(max, count);
        prevChar = element;
        count = 0;
      }
    }

    return max;
  }
}
