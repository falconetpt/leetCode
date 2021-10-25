package exercises.blind;

public class DecodeWays {
  public int numDecodings(final String s) {
    final var result = new int[s.length() + 2];
    result[s.length() - 1] = s.charAt(s.length() - 1) == '0'
      ? 0
      : 1;
    result[s.length()] = 1;

    for (int i = s.length() - 2; i >= 0; i--) {
      final var element = s.charAt(i) - '0';
      final var next = s.charAt(i + 1) - '0';
      final var nextElement = element * 10 + next;

      if (element > 0 && next != 0) {
        result[i] += result[i + 1];
      }

      if (next != nextElement && nextElement > 0 && nextElement < 27) {
        result[i] += result[i + 2];
      }

    }

    return result[0];
  }
}
