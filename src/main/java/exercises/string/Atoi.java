package exercises.string;

import java.util.Set;

public class Atoi {
  private static final Set<Character> VALID_CHARS = Set.of(
    '1', '2', '3', '4',
    '5', '6', '7', '8',
    '9', '0', '+', '-'
  );

  public int myAtoi(final String s) {
    final var value = s.trim();

    var index = 0;
    var mult = 1;
    var result = 0l;

    while (index < value.length()
      && VALID_CHARS.contains(value.charAt(index))) {
      final var element = value.charAt(index);


      if (element == '+' || element == '-') {
        if(index > 0) return (int) result * mult;
        mult = element == '+'
          ? 1
          : -1;
      } else {
        final var newResult = result * 10 + element - '0';
        if (newResult > Integer.MAX_VALUE) {
          return mult == -1
            ? Integer.MIN_VALUE
            : Integer.MAX_VALUE;
        } else {
          result = newResult;
        }
      }

      index++;

    }

    return (int) result * mult;
  }

}
