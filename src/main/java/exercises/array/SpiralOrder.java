package exercises.array;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpiralOrder {
  public List<Integer> spiralOrder(final int[][] matrix) {
    final var moves = Stream.of(
      new Point(0, 1),
      new Point(1, 0),
      new Point(0, -1),
      new Point(-1, 0)
    ).collect(Collectors.toCollection(LinkedList::new));

    final var set = new HashSet<Point>();

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        set.add(new Point(i, j));
      }
    }

    return spiralOrder(matrix, new Point(0, 0), moves, set, new ArrayList<>());
  }

  private List<Integer> spiralOrder(final int[][] matrix,
                                    final Point point,
                                    final LinkedList<Point> moves,
                                    final Set<Point> set,
                                    final List<Integer> integers) {
    if (set.isEmpty()) {
      return integers;
    } else {
      set.remove(point);
      integers.add(matrix[point.x][point.y]);

      final var nextPoint = moves.peekFirst();
      final var newPoint = new Point(nextPoint.x + point.x, nextPoint.y + point.y);

      if (set.contains(newPoint)) {
        return spiralOrder(matrix, newPoint, moves, set, integers);
      } else {
        moves.addLast(moves.pollFirst());

        final var twoFrom = moves.peekFirst();
        final var twoPoint = new Point(twoFrom.x + point.x, twoFrom.y + point.y);
        return spiralOrder(matrix, twoPoint, moves, set, integers);
      }
    }
  }
}
