package meetingRoom;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class MyCalendar {
  private TreeMap<Integer, Integer> treeMap;

  public MyCalendar() {
    this.treeMap = new TreeMap<>();
  }

  public boolean book(int startTime, int endTime) {
    return bookTree(startTime, endTime);
  }

  public boolean bookTree(int startTime, int endTime) {
    final var floor = treeMap.floorEntry(startTime);
    final var ceiling = treeMap.ceilingEntry(startTime);

    final var canBookBegining = floor == null
        || (startTime >= floor.getValue());
    final var canBookEnd = ceiling == null
        || ( endTime <= ceiling.getKey());;

    if (canBookBegining && canBookEnd) {
      treeMap.put(startTime, endTime);
      return true;
    } else {
      return false;
    }
  }
}
