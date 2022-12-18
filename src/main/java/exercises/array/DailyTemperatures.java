package exercises.array;

public class DailyTemperatures {
  public int[] dailyTemperatures(final int[] temperatures) {
    final var result = new int[temperatures.length];

    for (int i = temperatures.length - 2; i >= 0; i--) {
      result[i] = findHigherTemp(i, temperatures, result);
    }

    return result;
  }

  private int findHigherTemp(final int i,
                             final int[] temperatures,
                             final int[] result) {
    final var temperature = temperatures[i];

    for (int j = i + 1; j < temperatures.length; j++) {
      final var nextTemperature = temperatures[j];

      if (nextTemperature > temperature) {
        return j - i;
      } else {
        if (result[j] == 0) {
          return 0;
        } else {
          j += result[j] - 1;
        }
      }
    }

    return 0;
  }
}
