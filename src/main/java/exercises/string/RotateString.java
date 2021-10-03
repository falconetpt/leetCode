package exercises.string;

public class RotateString {
  public void reverseString(final char[] s) {
    var start = 0;
    var end = s.length - 1;

    while (start < end) {
      final var tmp = s[start];
      s[start] = s[end];
      s[end] = tmp;

      start++;
      end--;
    }
  }
}
