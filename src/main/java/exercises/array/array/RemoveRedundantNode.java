package exercises.array.array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.stream.Stream;

public class RemoveRedundantNode {
  public int[] findRedundantConnection(int[][] edges) {
    final var list = new LinkedList<int[]>();
    final var seen = new HashSet<>();

    for (final var edge : edges) {
      final var first = edge[0];
      final var second = edge[1];

      if (Stream.of(first, second).allMatch(seen::contains)) {
        list.add(edge);
      } else {
        Stream.of(first, second).forEach(seen::add);
      }
    }

    return list.pop();
  }
}
