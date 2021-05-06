package exercises.string;

import java.util.Map;

public class RomanNumeral {
  final static Map<Character, Integer> map = Map.of(
    'i', 1,
    'v', 5,
    'x', 10,
    'l', 50,
    'c', 100
  );

  public static int convert(final String value) {
    int result = 0;
    int previousValue = 0;
    int currentValue = 0;

    for (int i = 0; i < value.length(); i++) {
      previousValue = currentValue;
      currentValue = map.get(value.charAt(i));

      if (currentValue > previousValue) {
        result += currentValue - previousValue * 2;
      } else {
        result += currentValue;
      }
    }

    return result;
  }
}
