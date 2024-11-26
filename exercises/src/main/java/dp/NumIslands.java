package dp;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class NumIslands {
  private final static Set<Point> MOVES = Set.of(
      new Point(0, 1),
      new Point(0, -1),
      new Point(-1, 0),
      new Point(1, 0)
  );
  public int numIslands(char[][] grid) {
    final var landCoordinates = fetchLandCoordinates(grid);
    final var seen = new HashSet<Point>();

    var count = 0;

    while (!landCoordinates.isEmpty()) {
      final var next = landCoordinates.stream().findFirst().orElseThrow();
      expandIsland(next, landCoordinates, seen);
      count++;
    }

    return count;

  }

  private void expandIsland(Point next, Set<Point> landCoordinates, HashSet<Point> seen) {

    seen.add(next);
    landCoordinates.remove(next);

    // System.out.println("seen: "+seen);
    //           System.out.println("Land C" + landCoordinates);
    final var moves = MOVES.stream()
        .map(p -> new Point(next.x + p.x, next.y + p.y))
        .filter(landCoordinates::contains)
        .peek(seen::add)
        .peek(landCoordinates::remove)
        .collect(Collectors.toSet());
    // System.out.println("=====" + moves);


    moves.forEach(p -> expandIsland(p, landCoordinates, seen));
  }

  private Set<Point> fetchLandCoordinates(char[][] grid) {
    final var result = new HashSet<Point>();

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '1') result.add(new Point(i, j));
      }
    }

    return result;
  }


  private record Point(int x, int y) {}
}
