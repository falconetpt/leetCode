package finalPrep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class IntervalIntersection {
  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    Arrays.sort(firstList, Comparator.comparing(a -> a[0])); // O (n log n)
    Arrays.sort(secondList, Comparator.comparing(a -> a[0])); // O (n log n)

    var fistIndex = 0;
    var secondIndex = 0;

    final var result = new LinkedList<int[]>();


    while (fistIndex < firstList.length && secondIndex < secondList.length) {
      final var firstValue = firstList[fistIndex];
      final var secondValue = secondList[secondIndex];

      final var interval = new int[] { Math.max(firstValue[0], secondValue[0]), Math.min(firstValue[1], secondValue[1]) };

      if (interval[1] - interval[0] >= 0) {
        result.add(interval);
      }

      if (firstValue[1] > secondValue[1]) {
        secondIndex++;
      } else {
        fistIndex++;
      }

    }

    return result.toArray(int[][]::new);
  }
}
