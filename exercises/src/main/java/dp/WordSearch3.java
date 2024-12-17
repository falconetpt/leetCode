package dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordSearch3 {
  private final static Set<Point> MOVES = Set.of(
      new Point(0, 1),
      new Point(0, -1),
      new Point(1, 0),
      new Point(-1, 0)
  );
  public boolean exist(char[][] board, String word) {
    final var map = extractMap(board, word);
    return map.getOrDefault(word.charAt(0), Set.of())
        .stream()
        .anyMatch(p -> {
          final var seen = new HashSet<Point>();
          return exist(word, map, seen, p, 1);
        });
  }

  private boolean exist(String word, HashMap<Character, Set<Point>> map, HashSet<Point> seen,
                        Point prevPoint,  int index) {
    if (index >= word.length()) return true;
    final var element = word.charAt(index);
    seen.add(prevPoint);

    if (!map.containsKey(element)) return false;

    final var result = map.getOrDefault(element, Set.of())
        .stream()
        .filter(p -> MOVES.contains(new Point(prevPoint.row - p.row, prevPoint.col - p.col)))
        .filter(p -> !seen.contains(p))
        .anyMatch(p -> exist(word, map, seen, p, index + 1));

    seen.remove(prevPoint);

    return result;
  }

  private HashMap<Character, Set<Point>> extractMap(char[][] board, String word) {
    final var map = new HashMap<Character, Set<Point>>();

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        final var element = board[i][j];
        map.putIfAbsent(element, new HashSet<>());
        map.get(element).add(new Point(i, j));
      }
    }

    return map;
  }

  private record Point(int row, int col) {}
}
