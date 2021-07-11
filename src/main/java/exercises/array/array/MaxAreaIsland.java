package exercises.array.array;

import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxAreaIsland {
  public final static List<Point> moves = List.of(
    new Point(0, 1),
    new Point(0, -1),
    new Point(1, 0),
    new Point(-1, 0)
  );

  public int maxAreaOfIsland(final int[][] grid) {
    final var landList = IntStream.range(0, grid.length)
      .boxed()
      .flatMap(x -> IntStream.range(0, grid[x].length).mapToObj(y -> new Point(x, y)))
      .filter(p -> grid[p.x][p.y] == 1)
      .collect(Collectors.toCollection(LinkedList::new));
    final var landSet = new HashSet<>(landList);

    return maxAreaOfIsland(landList, landSet, 0);
  }

  private int maxAreaOfIsland(final LinkedList<Point> landList,
                              final Set<Point> landSet,
                              int maxArea) {
    if (landSet.isEmpty()) {
      return maxArea;
    } else {
      final var next = landList.pollFirst();

      if (landSet.contains(next)) {
        landSet.remove(next);
        final var nextPoints = moves.stream()
          .map(m -> new Point(m.x + next.x, m.y + next.y))
          .filter(landSet::contains)
          .peek(landSet::remove)
          .collect(Collectors.toCollection(LinkedList::new));
        final int area = 1 + expandArea(nextPoints, landSet);

        return maxAreaOfIsland(landList, landSet, Math.max(area, maxArea));
      } else {
        return maxAreaOfIsland(landList, landSet, maxArea);
      }
    }
  }

  private int expandArea(final LinkedList<Point> nextPoints,
                         final Set<Point> landSet) {
    if (nextPoints.isEmpty()) {
      return 0;
    } else {
      final var next = nextPoints.pollFirst();
      landSet.remove(next);
      moves.stream()
        .map(m -> new Point(m.x + next.x, m.y + next.y))
        .filter(landSet::contains)
        .peek(landSet::remove)
        .forEach(nextPoints::add);
      return 1 + expandArea(nextPoints, landSet);
    }
  }
}
