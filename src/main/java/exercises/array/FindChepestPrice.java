package exercises.array;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class FindChepestPrice {
  public int findCheapestPrice(final int n,
                               final int[][] flights,
                               final int src,
                               final int dst,
                               final int k) {
//    final var priorityQueue = new PriorityQueue<Point>(Comparator.comparing(p -> p.x));
    final var map = new HashMap<Integer, LinkedList<Point>>();
    Arrays.stream(flights)
      .peek(f -> map.putIfAbsent(f[0], new LinkedList<>()))
      .forEach(f -> map.get(f[0]).add(new Point(f[1], f[2])));

    return findCheapestPrice(src, dst, k + 1, map, 0);
  }

  private int findCheapestPrice(final int src, final int dst, final int k,
                                final HashMap<Integer, LinkedList<Point>> map, final int cost) {
    if (src == dst && k >= 0) {
      return cost;
    } if (k == 0 || !map.containsKey(src)) {
      return Integer.MAX_VALUE;
    } else {
      return map.remove(src)
        .stream()
        .map(i -> findCheapestPrice(i.x, dst, k - 1, map, cost + i.y))
        .min(Integer::compareTo)
        .orElse(Integer.MAX_VALUE);
    }
  }
}
