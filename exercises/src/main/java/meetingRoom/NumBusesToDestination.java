package meetingRoom;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class NumBusesToDestination {
  public int numBusesToDestination(int[][] routes, int source, int target) {
    final var queue = new PriorityQueue<Data>(Comparator.comparing(d -> d.weight));
    final var map = fillConnections(routes);
    final var seen = new HashSet<Integer>();

    queue.add(new Data(source, 0));
    seen.add(source);

    return numBusesToDestination(queue, seen, map, target);
  }

  private int numBusesToDestination(PriorityQueue<Data> queue,
                                    HashSet<Integer> seen,
                                    Map<Integer, Set<Integer>> map,
                                    int target) {
    if (queue.isEmpty()) return -1;

    final var next = queue.poll();
    seen.add(next.source);
    if (next.source == target) return next.weight;

    map.getOrDefault(next.source, Set.of())
        .stream()
        .filter(e -> !seen.contains(e))
        .map(e -> new Data(e, next.weight + 1))
        .forEach(queue::add);

    return numBusesToDestination(queue, seen, map, target);
  }

  private Map<Integer, Set<Integer>> fillConnections(int[][] routes) {
    final var result = new HashMap<Integer, Set<Integer>>();

    for (int i = 0; i < routes.length; i++) {
      final var set = Arrays.stream(routes[i])
          .boxed()
          .collect(Collectors.toSet());

      for (int j = 0; j < routes[i].length; j++) {
        result.putIfAbsent(routes[i][j], new HashSet<>());
        result.get(routes[i][j]).addAll(set);
      }
    }

    return result;
  }

  public record Data(int source, int weight){};
}
