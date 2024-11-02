package exercises.u.exercises;

import java.awt.Point;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

public class TowerHeights {
  private final static Set<Point> Moves = Set.of(
      new Point(0, 1),
      new Point(1, 0),
      new Point(-1, 0),
      new Point(0, -1)
  );

  public int maxJump(int[][] points) {
    var max = 0;
    final var map = new HashMap<String, Integer>();

    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j < points[i].length; j++) {
        final var jumps = calculateMaxJumps(points, new Point(i, j), map);
        max = Math.max(jumps, max);
      }
    }

    return max;
  }

  private int calculateMaxJumps(int[][] points, Point currentPoint, HashMap<String, Integer> map) {
    final var point = currentPoint.x + ":" + currentPoint.y;
    System.out.println("points = " + currentPoint);
    if (map.containsKey(point)) {
      System.out.println("Found element = " + currentPoint);
      return map.get(point);
    }

    System.out.println("points = " + currentPoint);

    if (isValidPoint(points, currentPoint)) {
      map.put(point, 0);

      final var maxMoves = Moves.stream()
          .map(p -> new Point(currentPoint.x + p.x, currentPoint.y + p.y))
          .filter(p -> isValidPoint(points, p))
          .filter(p -> points[p.x][p.y] > points[currentPoint.x][currentPoint.y])
          .map(p -> 1 + calculateMaxJumps(points, p, map))
          .max(Comparator.comparingInt(value -> value))
          .orElse(1);

      map.put(point, Math.max(maxMoves, map.getOrDefault(point, 0)));
      return maxMoves;
    } else {
      return 0;
    }
  }

  private boolean isValidPoint(int[][] points, Point currentPoint) {
    try {
      return points[currentPoint.x][currentPoint.y] >= Integer.MIN_VALUE;
    } catch (ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }
}
