package u.exercises;

import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NumIslands {
  private final static List<Point> MOVES = List.of(
      new Point(1, 0),
      new Point(-1, 0),
      new Point(0, 1),
      new Point(0, -1)
  );


  public int numIslands(char[][] grid) {
    final var linkedList = fillWithIslandCoordinates(grid);
    final var islandMap = fillWithIslandCoordinates(grid).stream()
        .map(p -> p.x + ":" + p.y)
        .collect(Collectors.toSet());

    final var seen = new HashSet<String>();

    var islands = 0;

    while (!linkedList.isEmpty()) {
      final var next = linkedList.pollFirst();
      if (!seen.contains(next.x + ":" + next.y)) {
        expandIsland(next, islandMap, seen);
        islands++;
      }
    }

    return islands;
  }

  private void expandIsland(Point next, Set<String> islandMap, Set<String> seen) {
    if (next != null) {
      seen.add(next.x + ":" + next.y);
      MOVES.stream()
          .map(p -> new Point(next.x + p.x, next.y + p.y))
          .filter(p -> islandMap.contains(p.x + ":" + p.y))
          .filter(p -> !seen.contains(p.x + ":" + p.y))
          .forEach(p -> expandIsland(p, islandMap, seen));
    }
  }

  private LinkedList<Point> fillWithIslandCoordinates(char[][] grid) {
    final var result = new LinkedList<Point>();

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '1') result.add(new Point(i, j));
      }
    }

    return result;
  }
}
