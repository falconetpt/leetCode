package meetingRoom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntervalIntercection {
  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    if (firstList.length == 0 || secondList.length == 0) return new int[][] {}; // if empty return empty


    // sort both lists
    Arrays.sort(firstList, Comparator.comparing(a -> a[0]));
    Arrays.sort(secondList, Comparator.comparing(a -> a[0]));

    var firstPointer = 0;
    var secondPointer = 0;

    final List<int[]> result = new ArrayList<>();

    while (firstPointer < firstList.length && secondPointer < secondList.length) {
      final var newInterval = new int[] {
          Math.max(firstList[firstPointer][0], secondList[secondPointer][0]),
          Math.min(firstList[firstPointer][1], secondList[secondPointer][1])
      };

      if (firstList[firstPointer][1] >= secondList[secondPointer][1]) {
        secondPointer++;
      } else if (secondList[secondPointer][1] >= firstList[firstPointer][1]) {
        firstPointer++;
      }

      if (newInterval[1] - newInterval[0] >= 0) result.add(newInterval);
    }

    return result.toArray(int[][]::new);
  }
}
