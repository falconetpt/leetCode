package exercises.array;

import java.util.ArrayList;

public class MergeSet {
  public int[][] intervalIntersection(final int[][] firstList, final int[][] secondList) {
    var first = 0;
    var second = 0;
    final var result = new ArrayList<int[]>();


    while (first < firstList.length && second < secondList.length) {
      final var firstValue = firstList[first];
      final var secondValue = secondList[second];

      final var test = new int[] {
        Math.max(firstValue[0], secondValue[0]),
        Math.min(firstValue[1], secondValue[1])
      };

      if (test[1] >= test[0]) {
        result.add(test);
      }

      if (firstValue[1] > secondValue[1]) {
        second++;
      } else {
        first++;
      }
    }

    return result.toArray(int[][]::new);
  }
}
