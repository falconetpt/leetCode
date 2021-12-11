package exercises.array;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class LargestTriangleArea {
  public double largestTriangleArea(final int[][] points) {
    final Map<Integer, Integer> xMap = new HashMap<>();
    final Map<Integer, Integer> yMap = new HashMap<>();

    for (final var point : points) {
      final var p = new Point(Math.abs(point[0]), Math.abs(point[1]));
      xMap.putIfAbsent(p.x, p.y);
      yMap.putIfAbsent(p.y, p.x);

      xMap.put(p.x, Math.max(xMap.get(p.x), p.y));
      yMap.put(p.y, Math.max(yMap.get(p.y), p.x));
    }

    var total = 0d;

    for (final var element : xMap.entrySet()) {
      final var base = element.getKey();

      if (yMap.containsKey(base)) {
        total = Math.max(total, element.getValue() * yMap.get(base) / 2.0);
      }
    }

    return total;
  }
}
