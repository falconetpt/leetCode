package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CountUnguarded {
  private final static Set<Point> MOVES = Set.of(
      new Point(1, 0),
      new Point(-1, 0),
      new Point(0, 1),
      new Point(0, -1)
  );


  public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
    final var dp = new int[m][n];
    final var remaining = new HashSet<Point>();
    final var guardsLocation = Arrays.stream(guards)
        .map(i -> new Point(i[0], i[1]))
        .collect(Collectors.toSet());

    final var wallLocation = Arrays.stream(walls)
        .map(i -> new Point(i[0], i[1]))
        .collect(Collectors.toSet());

    fillArr(dp, guardsLocation, wallLocation, remaining);

    final var canTraverse = new HashSet<Point>(remaining);

    // System.out.println(remaining);
    // System.out.println("-----");

    guardsLocation.forEach(p -> expand(p, remaining, canTraverse));

    // System.out.println(remaining);

    return remaining.size();
  }

  private void expand(Point p, HashSet<Point> remaining, HashSet<Point> canTraverse) {
    remaining.remove(p);

    for (final var move : MOVES) {
      var newPoint = new Point(p.x + move.x, p.y + move.y);
      var count = 1;

      while (canTraverse.contains(newPoint)) {
        remaining.remove(newPoint);
        newPoint = new Point(p.x + move.x * count, p.y + move.y * count);
        count++;
      }
    }
  }

  private void fillArr(int[][] dp, Set<Point> walls, Set<Point> guards,
                       HashSet<Point> remaining) {
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[i].length; j++) {
        final var point = new Point(i, j);
        if (!walls.contains(point)) {
          if (!guards.contains(point)) remaining.add(point);
        }
      }
    }
  }

  private record Point(int x, int y) {}
}
