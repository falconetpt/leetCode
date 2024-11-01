package exercises.u.exercises;

import java.util.stream.IntStream;

public class StringCompression {

  public int compress(char[] chars) {
    final var string = String.valueOf(chars);

    final var compressed = stringCompression(string);

    IntStream.range(0, compressed.length())
        .forEach(i -> chars[i] = compressed.charAt(i));

    return compressed.length();
  }

  public String stringCompression(final String s) {
    final var stringWithExtraSpace = s + " "; //we have upper and lower cases, so by using a space i safeguard my algo
    var count = 1;
    final var sb = new StringBuilder();

    for (int i = 1; i < stringWithExtraSpace.length(); i++) {
      if (stringWithExtraSpace.charAt(i) == stringWithExtraSpace.charAt(i - 1)) {
        count++;
      } else {
        final var countStr = count == 1
            ? ""
            : String.valueOf(count);

        sb.append(stringWithExtraSpace.charAt(i - 1) + countStr);
        count = 1;
      }
    }

    return sb.toString();
  }
}
