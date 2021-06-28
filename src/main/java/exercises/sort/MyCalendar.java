package exercises.sort;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class MyCalendar {
  private TreeMap<Integer, Integer> map;

  public MyCalendar() {
    map = new TreeMap<>( Comparator.comparingInt( i -> i ) );
  }


  public boolean book(int start, int end) {
    final var overlaps = map.entrySet()
      .stream()
      .anyMatch( i -> overlaps(i, start, end) );

    if (overlaps) {
      return false;
    } else {
      map.put( start, end );
      return true;
    }

  }

  private boolean overlaps(final Map.Entry<Integer, Integer> i,
                           final int start,
                           final int end) {
    final var entryStart = i.getKey();
    final var entryEnd = i.getValue();

    final var startInRange = start >= entryStart
      && start < entryEnd;

    final var endInRange = end > entryStart
      && end < entryEnd;

    return startInRange || endInRange;
  }
}