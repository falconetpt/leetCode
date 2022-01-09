package exercises.linked.list;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class CarPooling {
  public boolean carPooling(final int[][] trips, final int capacity) {
    Arrays.sort(trips, Comparator.comparing(i -> i[1]));
    final var map = new LinkedList<int[]>();
    map.addLast(new int[] { trips[0][0], trips[0][1], trips[0][2] });

    for (int i = 1; i < trips.length; i++) {
      final var elements = trips[i];
      final var lastElement = map.peekLast();

      if (elements[1] <= lastElement[2]) {
        final var newCapacity = lastElement[0] + elements[0];
        if (newCapacity > capacity) return false;
        lastElement[0] = newCapacity;
        lastElement[2] = Math.max(elements[2], lastElement[2]);
      } else {
        map.addLast(new int[] { elements[0], elements[1], elements[2] });
      }
    }

    return true;
  }
}
