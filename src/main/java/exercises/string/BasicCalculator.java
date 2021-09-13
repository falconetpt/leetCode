package exercises.string;

import java.util.Map;
import java.util.function.BiFunction;

public class BasicCalculator {
  private final static Map<Character, BiFunction<Integer, Integer, Integer>> map = Map.of(
    '+', BasicCalculator::sum,
    '-', BasicCalculator::subtract
  );

  private final static char OPEN_PARENTHESIS = '(';
  private final static char CLOSE_PARENTHESIS = ')';

  public int calculate(final String s) {
    final var newString = s
      .replace(" ", "");

    return calculate(newString, 0)
      .total;
  }

  private CalculatedInfo calculate(final String s,
                                   final int index) {
    var a = 0;
    var b = 0;
    var aFlag = true;
    var operation = '+';
    var total = 0;

    for (int i = index; i < s.length(); i++) {
      final var element = s.charAt(i);

      if (element == OPEN_PARENTHESIS) {
        final var newOperation = calculate(s, i + 1);
        i = newOperation.finalIndex;
        b = newOperation.total;
        total += map.get(operation).apply(a, b);
        a = 0;
        b = 0;
        aFlag = !aFlag;
      } else if (element == CLOSE_PARENTHESIS) {
        if (map.containsKey(operation)) total += map.get(operation).apply(a, b);
        return new CalculatedInfo(i, total);
      } else if (map.containsKey(element)) {
        total += map.get(operation).apply(a, b);
        a = 0;
        b = 0;

        aFlag = false;

        operation = element;
      } else {
        final var value = element - '0';
        if (aFlag) {
          a = a * 10 + value;
        } else {
          b = b * 10 + value;
        }
      }
    }

    if (map.containsKey(operation)) total += map.get(operation).apply(a, b);

    return new CalculatedInfo(0, total);
  }

  private static int sum(final int a, final int b) {
    return a + b;
  }

  private static int subtract(final int a, final int b) {
    return a - b;
  }

  private final class CalculatedInfo {
    private int total;
    private int finalIndex;

    public CalculatedInfo(final int finalIndex, final int total) {
      this.total = total;
      this.finalIndex = finalIndex;
    }
  }
}
