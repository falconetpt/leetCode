package exercises.u.exercises;

import java.util.Arrays;
import java.util.Comparator;

public class MinNumberOfLines {
  public int minimumLines(int[][] stockPrices) {

    if (stockPrices.length == 1 ) return 0;
    if (stockPrices.length == 2 ) return 1;

    Arrays.sort(stockPrices, Comparator.comparing(s -> s[0])); // O (n log n)

    var count = 1;
    var lastInclination = calculateInclination(stockPrices, 1, 0);

    for (int i = 1; i < stockPrices.length; i++) {
      var difference = calculateInclination(stockPrices, i, i -1);

      if (Math.abs(difference - lastInclination) != 0.0000000) {
        count++;
        lastInclination = difference;
      }
    }

    return count;
  }

  private static double calculateInclination(int[][] stockPrices, int current, int prev) {
    return (double) (stockPrices[current][1] - stockPrices[prev][1])
        / (double) (stockPrices[current][0] - stockPrices[prev][0]);
  }
}
