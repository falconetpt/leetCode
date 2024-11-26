package dp;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindChampion {
  public int findChampion(int n, int[][] edges) {
    final var nodes = IntStream.range(0, n)
        .boxed()
        .collect(Collectors.toSet());

    for (final var edge : edges) {
      final var origin = edge[0];
      final var destination = edge[1];

      nodes.remove(destination);
    }


    if (nodes.size() != 1) return -1;
    return nodes.stream().findFirst().orElseThrow();
  }
}
