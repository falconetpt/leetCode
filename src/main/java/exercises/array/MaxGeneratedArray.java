package exercises.array;

public class MaxGeneratedArray {
  public int getMaximumGenerated(int n) {
    if (n < 2) return n;

    final var values = new int[n + 1];
    values[0] = 0;
    values[1] = 1;
    var max = 1;

    for (int i = 2; i < values.length; i++) {
      if (i % 2 == 0) {
        values[i] = values[i/2];
      } else {
        values[i] = values[i/2] + values[i/2 + 1];
        max = Math.max(max, values[i]);
      }
    }

    return max;
  }
}
