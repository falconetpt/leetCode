package exercises.array;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordExists {
  private static final List<Point> MOVES = List.of(
    new Point(0, 1),
    new Point(0, -1),
    new Point(1, 0),
    new Point(-1, 0)
  );

  public boolean exist(final char[][] board, final String word) {
    final var points = findPoints(word.charAt(0), board);
    return exist(board, word, 0, points, new HashSet<>());
  }

  private boolean exist(final char[][] board,
                        final String word,
                        final int i,
                        List<Point> points,
                        final Set<Point> seen) {
    if (i >= word.length() - 1) {
      return points.stream()
        .anyMatch(p -> board[p.x][p.y] == word.charAt(word.length() - 1));
    } else {
      final var element = word.charAt(i + 1);

      for (final var point : points) {
        seen.add(point);

        final var newPoints = MOVES.stream()
          .map(p -> new Point(p.x + point.x, p.y + point.y))
          .filter(p -> !seen.contains(p))
          .filter(p -> validElement(board, p, element))
          .collect(Collectors.toList());

        if (exist(board, word, i + 1, newPoints, seen)) return true;

        seen.remove(point);
      }

      return false;
    }
  }

  private boolean validElement(final char[][] board, final Point p, final char element) {
    try {
      return board[p.x][p.y] == element;
    } catch (final ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }

  private List<Point> findPoints(final char charAt, final char[][] board) {
    final var result = new ArrayList<Point>();

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        final var element = board[i][j];
        if (element == charAt) result.add(new Point(i, j));
      }
    }

    return result;
  }
}
