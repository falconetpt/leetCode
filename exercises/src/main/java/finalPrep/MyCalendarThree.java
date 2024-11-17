package finalPrep;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MyCalendarThree {

  private final Map<Integer, Integer> map = new TreeMap<>();

  public MyCalendarThree() {

  }

  public int book(int startTime, int endTime) {
    map.put(startTime, map.getOrDefault(startTime, 0) + 1);
    map.put(endTime, map.getOrDefault(startTime, 0) - 1);

    var sum = 0;
    var max = sum;

    for (final var value : map.values()) {
      sum += value;
      max = Math.max(sum, max);
    }

    return max;
  }
}
