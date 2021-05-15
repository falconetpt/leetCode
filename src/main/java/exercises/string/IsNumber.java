package exercises.string;

import java.util.Arrays;
import java.util.Set;

public class IsNumber {
  public boolean isNumber(final String s) {
    try {
      final var set = Set.of(
        "0",
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "e",
        "E",
        ".",
        "+",
        "-"
      );
      Double.parseDouble(s);
      return Arrays.stream(s.split(""))
        .allMatch(set::contains);
    } catch (Exception e) {
      return false;
    }
  }
}
