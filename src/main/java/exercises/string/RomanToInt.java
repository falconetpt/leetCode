package exercises.string;

import java.util.Map;

public class RomanToInt {
  private static Map<Character, Integer> romanToInt = Map.of(
    'I', 1,
    'V', 5,
    'X', 10,
    'L', 50,
    'C', 100,
    'D', 500,
    'M', 1000
  );

  public int romanToInt(final String s) {
    var prev = 0;
    var total = 0;

    for (int i = 0; i < s.length(); i++) {
      final var element = romanToInt.get(s.charAt(i));
      if (element > prev) total -= prev * 2;
      total += element;
      prev = element;
    }

    return total;
  }
}
