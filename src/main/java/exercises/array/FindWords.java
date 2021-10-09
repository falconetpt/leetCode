package exercises.array;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FindWords {
  private static final List<Point> MOVES = List.of(
    new Point(1, 0),
    new Point(-1, 0),
    new Point(0, 1),
    new Point(0, -1)
  );

  public List<String> findWords(final char[][] board,
                                final String[] words) {
    final var map = letterByCoodinate(board);

    return Arrays.stream(words)
      .filter(w -> hasWord(w,  map))
      .collect(Collectors.toList());
  }

  private boolean hasWord(final String w,
                          final Map<Character, Set<Point>> map) {
    final var element = w.charAt(0);
    final var points = map.getOrDefault(element, Set.of());

    for (final var point : points) {
      if (hasWord(w, 1, map, point, new HashSet<>() {{ add(point); }})) return true;
    }

    return false;
  }

  private boolean hasWord(final String w,
                          final int i,
                          final Map<Character, Set<Point>> map,
                          final Point base,
                          final Set<Point> seen) {
    if (i >= w.length()) {
      return true;
    } else {
      final var element = w.charAt(i);

      return MOVES.stream()
        .map(p -> new Point(p.x + base.x, p.y + base.y))
        .filter(p -> !seen.contains(p))
        .filter(p -> map.getOrDefault(element, Set.of()).contains(p))
        .anyMatch(p -> {
          seen.add(p);
          final var result = hasWord(w, i + 1, map, p, seen);
          seen.remove(p);
          return result;
        });
    }
  }

  private Map<Character, Set<Point>> letterByCoodinate(final char[][] board) {
    final var result = new HashMap<Character, Set<Point>>();

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        final var element = board[i][j];
        result.putIfAbsent(element, new HashSet<>());
        result.get(element).add(new Point(i, j));
      }
    }

    return result;
  }
}
