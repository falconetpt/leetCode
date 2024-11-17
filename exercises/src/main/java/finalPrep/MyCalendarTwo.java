package finalPrep;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

public class MyCalendarTwo {

  private final TreeMap<Integer, Integer> map;


  public MyCalendarTwo() {
    map = new TreeMap<>();
  }

  public boolean book(int startTime, int endTime) {
   // O (N) space
   // o(N) time
    var result = true;

    for (int i = startTime; i <= endTime; i++) {
      map.put(i, map.getOrDefault(i, 0) + 1);
      if (map.get(i) > 2) result  = false;
    }

    if (!result) {
      rollback(startTime, endTime);
    }

    return result;
  }

  private void rollback(int startTime, int endTime) {
    for (int i = startTime; i <= endTime ; i++) {
      map.put(i, map.get(i) - 1);
    }
  }
}
