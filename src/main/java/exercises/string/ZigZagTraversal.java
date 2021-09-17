package exercises.string;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ZigZagTraversal {
  public String convert(final String s, final int numRows) {
    if (numRows == 1) return s;
    final var moves = Stream.of(
      new Point(1, 0),
      new Point(-1, 1)
    ).collect(Collectors.toCollection(LinkedList::new));

    final var grid = new ArrayList<StringBuilder>();

    for (int i = 0; i < numRows; i++) {
      grid.add(new StringBuilder());
    }

    final var chars = Arrays.stream(s.split(""))
      .collect(Collectors.toCollection(LinkedList::new));

    var point = new Point(0, 0);

    while (!chars.isEmpty()) {
      grid.get(point.x).append(chars.pollFirst());

      final var next = moves.peekFirst();

      if (point.x + next.x >= numRows || point.x + next.x < 0) {
        moves.addLast(moves.pollFirst());
        final var nextPoint = moves.peekFirst();
        point = new Point(nextPoint.x + point.x, nextPoint.y);
      } else {
        point = new Point(next.x + point.x, next.y);
      }
    }

    return grid.stream()
      .reduce(StringBuilder::append)
      .orElse(new StringBuilder())
      .toString();
  }
}
