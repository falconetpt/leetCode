package exercises.array.array;

import java.awt.Point;
import java.util.HashMap;
import java.util.List;

public class WayToGoOffGrid {
  private final static List<Point> moves = List.of(
    new Point(1, 0),
    new Point(-1, 0),
    new Point(0, 1),
    new Point(0, -1)
  );

  public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
    final var matrix = new int[m][n];
    final var cache = new HashMap<Point, Integer>();

    final var startingPoint = new Point(startRow, startColumn);

    return 0;
  }
}
