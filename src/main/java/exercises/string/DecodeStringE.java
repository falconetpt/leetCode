package exercises.string;

import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DecodeStringE {
  private final static Set<Character> numberSet = Set.of(
    '0', '1', '2', '3',
    '4', '5', '6', '7',
    '8', '9'
  );
  private final static char openBracket = '[';
  private final static char closeBracket = ']';

  public String decodeString(final String s) {
    return decodeString(s, 0, 0, new StringInfo(0))
      .stringBuilder
      .toString();
  }

  private StringInfo decodeString(final String s,
                                  final int i,
                                  final int repeat,
                                  final StringInfo result) {
    if (i >= s.length()) {
      return result;
    } else {
      final var element = s.charAt(i);

      if (numberSet.contains(element)) {
        result.endIndex++;
        return decodeString(s, i + 1, repeat * 10 + (element - '0'), result);
      }

      if (element == openBracket) {
        final var child = decodeString(s, i + 1, 0, new StringInfo(i + 1));
        final var childStr = child.stringBuilder.toString();
        IntStream.range(0, repeat)
          .forEach(e -> result.stringBuilder.append(childStr));
        result.endIndex = child.endIndex;

        return decodeString(s, result.endIndex, 0, result);
      }

      if (element == closeBracket) {
        result.endIndex++;
        return result;
      }

      result.stringBuilder.append(element);
      result.endIndex++;

      return decodeString(s, i + 1, repeat, result);
    }
  }

  private class StringInfo {
    private StringBuilder stringBuilder = new StringBuilder();
    private int endIndex = 0;

    public StringInfo(final int endIndex) {
      this.endIndex = endIndex;
    }
  }
}
