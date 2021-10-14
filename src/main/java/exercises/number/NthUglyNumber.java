package exercises.number;

import java.util.HashMap;

public class NthUglyNumber {
  public int nthUglyNumber(int n) {
    final var result = new HashMap<Integer, Boolean>();
    result.put(1, true);

    var number = 1;
    var valid = 1;

    while (valid <= n) {
      if (isUgly(number, result)) {
        result.put(number, true);
        valid++;
      } else {
        result.put(number, false);
      }
      number++;
    }

    return number - 1;
  }

  private boolean isUgly(final int number,
                         final HashMap<Integer, Boolean> result) {
    if (result.containsKey(number)) {
      return result.get(number);
    } else {
      if (number % 2 == 0) {
        return result.get(number / 2);
      } else if (number % 3 == 0) {
        return result.get(number / 3);
      } else if (number % 5 == 0) {
        return result.get(number / 5);
      }
      return false;
    }
  }
}
