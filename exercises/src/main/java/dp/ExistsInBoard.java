package dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExistsInBoard {
  private final static Set<Point> MOVES = Set.of(
      new Point(0, 1),
      new Point(0, -1),
      new Point(1, 0),
      new Point(-1, 0)
  );

  public boolean exist(char[][] board, String word) {
    final var elementMap = createElementMap(board);
    final var seen = new HashSet<Point>();
    final var start = elementMap.getOrDefault(word.charAt(0), Set.of());
    final var cache = new HashMap<WordP, Boolean>();
    return start.stream().anyMatch(p -> existInWord(elementMap, word, p, 1, seen, cache));
  }

  private boolean existInWord(Map<Character, Set<Point>> elementMap, String word,
                              Point p, int i, HashSet<Point> seen, HashMap<WordP, Boolean> cache) {
    if (i >= word.length()) return true;
    final var nextChar = word.charAt(i);
//    if (cache.containsKey(new WordP(p, i))) return cache.get(new WordP(p, i));
    seen.add(p);


    final var match = MOVES.stream()
        .map(m -> new Point(m.x + p.x, m.y + p.y))
        .filter(m -> !seen.contains(m))
        .filter(m -> elementMap.getOrDefault(nextChar, Set.of()).contains(m))
        .anyMatch(m -> existInWord(elementMap, word, m, i + 1, seen, cache));

    seen.remove(p);

    cache.put(new WordP(p, i), match);

    return match;
  }


  private Map<Character, Set<Point>> createElementMap(char[][] board) {
    final var result = new HashMap<Character, Set<Point>>();

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        final var character = board[i][j];
        result.putIfAbsent(character, new HashSet<>());
        result.get(character).add(new Point(i, j));
      }
    }

    return result;
  }

  private record WordP(Point point, int index) {}

  private record Point(int x, int y) {
  }
}
