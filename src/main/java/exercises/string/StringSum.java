package exercises.string;

import java.util.LinkedList;

public class StringSum {
  public String addStrings(final String num1, final String num2) {
    return String.join("",
      addStrings(num1, num2, num1.length() - 1, num2.length() - 1, 0, new LinkedList<>())
    );
  }

  private LinkedList<String> addStrings(final String num1,
                                        final String num2,
                                        final int i1,
                                        final int i2,
                                        final int remainder,
                                        final LinkedList<String> strings) {
    if (i1 < 0 && i2 < 0) {
      if (remainder > 0) strings.addFirst(String.valueOf(remainder));
      return strings;
    } else {
      final var num1Value = i1 >= 0
        ? Integer.parseInt("" + num1.charAt(i1))
        : 0;
      final var num2Value = i2 >= 0
        ? Integer.parseInt("" + num2.charAt(i2))
        : 0;

      final var value = num1Value + num2Value
        + remainder;

      strings.addFirst(String.valueOf(value % 10));

      return addStrings(num1, num2, i1 - 1, i2 - 1, value / 10, strings);
    }
  }
}
