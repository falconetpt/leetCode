package finalPrep;

import java.util.TreeMap;

class MyCalendar {
  private final TreeMap<Integer, Integer> map;

  public MyCalendar() {
    map = new TreeMap<>();
  }

  public boolean book(int startTime, int endTime) {
    final var prevStart = map.floorKey(startTime);
    final var nextStart = map.ceilingKey(startTime);

    final var prevMax = prevStart == null
      ? Integer.MIN_VALUE
      : map.get(prevStart); //Default to min to ease it up
    final var nextMin = nextStart == null
        ? Integer.MAX_VALUE
        : nextStart; //Default to max to ease it up

    if (startTime >= prevMax && endTime <= nextMin) {
      map.put(startTime, endTime);
      return true;
    } else {
      return false;
    }
  }
}