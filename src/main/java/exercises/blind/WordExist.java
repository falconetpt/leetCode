package exercises.blind;

import java.util.HashSet;
import java.awt.Point;
import java.util.List;
import java.util.Set;

public class WordExist {
  private final List<Point> MOVES = List.of(
    new Point(1, 0),
    new Point(-1, 0),
    new Point(0, 1),
    new Point(0, -1)
  );

  public boolean exist(final char[][] board, final String word) {
    final var seen = new boolean[board.length][board[0].length];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        final var element = board[i][j];
        if (element == word.charAt(0)) {
          final var result = exist(board, new Point(i, j), word, 1, seen);
          if (result) return true;
        }
      }
    }

    return false;
  }

  private boolean exist(final char[][] board,
                        final Point point,
                        final String word,
                        final int i,
                        final boolean[][] seen) {
    if (i > word.length()) {
      return true;
    } else {
      seen[point.x][point.y] = true;

      final var next = MOVES.stream()
        .map(p -> new Point(p.x + point.x, p.y + point.y))
        .filter(p -> !seen[p.x][p.y])
        .filter(p -> isValid(board, p, word.charAt(i)))
        .anyMatch(p -> exist(board, p, word, i + 1, seen));

      seen[point.x][point.y] = false;

      return next;
    }
  }

  private boolean isValid(final char[][] board, final Point p, final char charAt) {
    try {
      return board[p.x][p.y] == charAt;
    } catch (final ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }
}
