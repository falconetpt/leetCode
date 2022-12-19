package exercises.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ValidPath {
  public boolean validPath(int n, int[][] edges, int source, int destination) {
    final var map = builMap(edges);
    final var visited = new HashSet<Integer>();
    final var toVisit = new LinkedList<Integer>();
    toVisit.add(source);

    return isValidPath(toVisit, visited, map, destination);
  }

  private boolean isValidPath(final LinkedList<Integer> toVisit,
                              final Set<Integer> visited,
                              final Map<Integer, Set<Integer>> map,
                              final int destination) {
    if (toVisit.isEmpty()) {
      return false;
    } else {
      final var next = toVisit.pollFirst();

      if (visited.contains(next)) {
        return isValidPath(toVisit, visited, map, destination);
      } else if (next == destination) {
        return true;
      } else {
        visited.add(next);
        map.getOrDefault(next, Set.of())
          .forEach(toVisit::add);
        return isValidPath(toVisit, visited, map, destination);
      }
    }
  }

  private Map<Integer, Set<Integer>> builMap(final int[][] edges) {
    final var map = new HashMap<Integer, Set<Integer>>();

    for (int i = 0; i < edges.length; i++) {
      map.putIfAbsent(edges[i][0], new HashSet<>());
      map.get(edges[i][0]).add(edges[i][1]);
      map.putIfAbsent(edges[i][1], new HashSet<>());
      map.get(edges[i][1]).add(edges[i][0]);
    }

    return map;
  }
}
