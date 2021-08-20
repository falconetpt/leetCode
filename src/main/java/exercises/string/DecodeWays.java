package exercises.string;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class DecodeWays {
  public int numDecodings(final String s) {
    final var result = new int[s.length() + 1];
    result[s.length()] = 1;
    if (s.charAt(s.length() - 1) - '0' > 0) result[s.length() - 1] = 1;

    for (int i = s.length() - 2; i >= 0; i--) {
      final var value = s.charAt(i) - '0';

      if (value > 0 ) {
        final var nextValue = s.charAt(i + 1) - '0';
        final var sum = value * 10 + nextValue;

        result[i] =result[i + 1];
        if (sum > 0 && sum < 27) {
          result[i] += result[i + 2];
        }
      }
    }

    return result[0];
  }
}
