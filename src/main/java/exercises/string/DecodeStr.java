package exercises.string;

import java.util.Set;
import java.util.stream.IntStream;

public class DecodeStr {
  private static final Set<Character> CHARACTERS = Set.of(
    '1', '2', '3',
    '4', '5', '6',
    '7', '8', '9', '0'
  );

  public String decodeString(final String s) {
    return decodeString(s, 0, new StringExpansion())
      .stringBuilder
      .toString();
  }

  private StringExpansion decodeString(final String s,
                                       final int i,
                                       final StringExpansion stringBuilder) {
    if (i >= s.length()) {
      return stringBuilder;
    } else {
      final var element = s.charAt(i);

      if (element == ']') {
        stringBuilder.endIndex = i + 1;
        return stringBuilder;
      } else if (CHARACTERS.contains(element)) {
        int reps = 0;
        var start = i;
        var localElement = element;

        while (CHARACTERS.contains(s.charAt(start))) {
          localElement = s.charAt(start);
          reps = reps * 10 + localElement - '0';
          start++;
        }

        final var expandElement = decodeString(s, start + 1, new StringExpansion());
        final var result = expandElement.stringBuilder.toString();

        IntStream.range(0, reps)
          .forEach(x -> stringBuilder.stringBuilder.append(result));

        return decodeString(s, expandElement.endIndex, stringBuilder);
      } else {
        stringBuilder.stringBuilder.append(element);
        return decodeString(s, i + 1, stringBuilder);
      }
    }
  }

  private class StringExpansion {
    private StringBuilder stringBuilder = new StringBuilder();
    private int endIndex;
  }
}
