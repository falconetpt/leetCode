package dp;

import java.util.List;
import java.util.TreeSet;

public class FindMinDifference {
  public int findMinDifference(List<String> timePoints) {
    final var elements = timePoints.stream().map(this::convertToInt).sorted()
        .toList();
    var min = Integer.MAX_VALUE;

    for (int i = 1; i < elements.size() + 1; i++) {
      if (i == elements.size()) {
        min = Math.min(min, 60 * 24 + elements.get(0) - elements.get(i - 1));
      } else {
        min = Math.min(min, elements.get(i) - elements.get(i -1));
      }
    }


    return min;
  }

  private int convertToInt(String time) {
    final var timeArr = time.split(":");
    final var hour = Integer.parseInt(timeArr[0]);
    final var minute = Integer.parseInt(timeArr[1]);

    return hour * 60 + minute;
  }
}
