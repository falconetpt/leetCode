package exercises.array;

import java.util.Arrays;

public class MaximumUnits {
  public int maximumUnits(int[][] boxTypes, int truckSize) {
    Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

    var result = 0;
    var remaining = truckSize;

    for (final var box : boxTypes) {
      if (remaining == 0) return result;

      result += Math.min(remaining, box[0]) * box[1];
      remaining -= Math.min(remaining, box[0]);
    }

    return result;
  }
}
