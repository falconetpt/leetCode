package exercises.array;

public class Temperature {
  public int[] dailyTemperatures(final int[] temperatures) {
    final var result = new int[temperatures.length];

    for (int i = 0; i < temperatures.length; i++) {
      final var first = temperatures[i];
      for (int j = i + 1; j < temperatures.length; j++) {
        if (temperatures[j] > first) {
          result[i] = j - i;
          break;
        }
      }
    }

    return result;
  }
}
