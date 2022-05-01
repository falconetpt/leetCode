package exercises.number;

import java.util.ArrayList;

public class RemoveDigit {
  public String removeDigit(final String number,
                            final char digit) {
    final var sb = new StringBuilder(number);
    final var list = new ArrayList<String>();

    for (int i = 0; i < number.length(); i++) {
      final var charElement = number.charAt(i);

      if (charElement == digit) {
        final var sbNew = new StringBuilder(sb);
        sbNew.deleteCharAt(i);
        list.add(sbNew.toString());
      }
    }

    return list.stream()
      .sorted((a, b) -> -a.compareTo(b))
      .findFirst()
      .orElse("0");
  }
}
