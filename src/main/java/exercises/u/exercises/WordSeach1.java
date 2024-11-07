package exercises.u.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class WordSeach1 {
  private final Set<Point> MOVES = Set.of(
      new Point(1, 0),
      new Point(-1, 0),
      new Point(0, 1),
      new Point(0, -1)
  );

  public boolean exist(char[][] board, String word) {
    final var fillMap = fillWords(board);

    final var result = new ArrayList<String>();

    return canFind(word, fillMap, new HashSet<Point>());

  }

  private boolean canFind(String word, HashMap<Character, Set<Point>> fillMap, HashSet<Point> seen) {
    final var firstElement = fillMap.getOrDefault(word.charAt(0), Set.of());
    return firstElement.stream()
        .anyMatch(p -> canFind(word, p, 1, fillMap, seen));
  }

  private boolean canFind(String word, Point prevPoint, int index, HashMap<Character, Set<Point>> fillMap, HashSet<Point> seen) {
    if (index >= word.length()) {
      return true;
    } else {
      seen.add(prevPoint);
      final var element = fillMap.getOrDefault(word.charAt(index), Set.of());

      final var result = element.stream()
          .filter(p -> MOVES.contains(new Point(prevPoint.x - p.x, prevPoint.y - p.y)))
          .filter(p -> !seen.contains(p))
          .anyMatch(p -> canFind(word, p, index + 1, fillMap, seen));

      seen.remove(prevPoint);

      return result;
    }
  }

  private HashMap<Character, Set<Point>> fillWords(char[][] board) {
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


  private class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Point point = (Point) o;
      return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }
}
