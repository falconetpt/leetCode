package exercises.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

public class MaxProbability {
  public double maxProbability(int n,
                               int[][] edges,
                               double[] succProb,
                               int start,
                               int end) {
    final var edgesMap = generateEdges(edges, succProb);
    final var queue = new PriorityQueue<Point>((a, b) -> Double.compare(b.probability, a.probability));
    final var seen = new HashSet<Integer>();


    queue.add(new Point(start, 1.0));
    while (!queue.isEmpty()) {
      final var next = queue.poll();
      seen.add(next.point);

      System.out.println(next.point);
      if (next.point == end) return next.probability;
      edgesMap.getOrDefault(next.point, Set.of())
        .stream()
        .filter(p -> !seen.contains(p.point))
        .map(p -> new Point(p.point, p.probability * next.probability))
        .forEach(queue::add);

    }

    return 0.0;
  }

  private Map<Integer, Set<Point>> generateEdges(final int[][] edges,
                                                 final double[] succProb) {
    final var result = new HashMap<Integer, Set<Point>>();

    for (int i = 0; i < edges.length; i++) {
      final var element = edges[i];
      final var probability = succProb[i];

      result.putIfAbsent(element[0], new HashSet<>());
      result.get(element[0]).add(new Point(element[1], probability));
      result.putIfAbsent(element[1], new HashSet<>());
      result.get(element[1]).add(new Point(element[0], probability));
    }

    return result;
  }


  private class Point {
    final int point;
    final double probability;

    public Point(final int point, final double probability) {
      this.point = point;
      this.probability = probability;
    }

    public int getPoint() {
      return point;
    }

    public double getProbability() {
      return probability;
    }


    @Override
    public boolean equals(final Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      final Point point1 = (Point) o;
      return point == point1.point;
    }

    @Override
    public int hashCode() {
      return Objects.hash(point);
    }
  }
}
