package exercises.blind;

import java.awt.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SpiralMatrix {
  private static final Deque<Point> MOVES = new LinkedList<>();

  public List<Integer> spiralOrder(int[][] matrix) {
    MOVES.clear();
    MOVES.add(new Point(0, 1));
    MOVES.add(new Point(1, 0));
    MOVES.add(new Point(0, -1));
    MOVES.add(new Point(-1, 0));

    final var map = new HashMap<Point, Integer>();

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        map.put(new Point(i, j), matrix[i][j]);
      }
    }

    return spiralOrder(map, new Point(0, 0), new ArrayList<>());
  }

  private List<Integer> spiralOrder(final Map<Point, Integer> map,
                                    final Point point,
                                    final List<Integer> integers) {
    if (map.isEmpty()) {
      return integers;
    } else if(map.size() == 1 && map.containsKey(point)) {
      integers.add(map.remove(point));
      return integers;
    } else {
      final var nextMove = MOVES.peekFirst();
      final var nextPoint = new Point(point.x + nextMove.x, point.y + nextMove.y);

      if (map.containsKey(nextPoint)) {
        final var value = map.remove(point);
        integers.add(value);
        return spiralOrder(map, nextPoint, integers);
      } else {
        MOVES.addLast(MOVES.pollFirst());
        return spiralOrder(map, point, integers);
      }
    }
  }
}
