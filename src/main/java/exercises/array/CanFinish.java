package exercises.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CanFinish {
  public boolean canFinish(final int numCourses, final int[][] prerequisites) {
    final var map = new HashMap<Integer, Set<Integer>>();

    for (final var prerequisite : prerequisites) {
      map.putIfAbsent(prerequisite[1], new HashSet<>());
      map.get(prerequisite[1]).add(prerequisite[0]);
    }

    final var seen = new HashSet<Integer>();
    for (final var entry : map.entrySet()) {
      if (!seen.contains(entry.getKey())) {
        final var isLoop = isLoop(map, seen, entry.getValue());
        if (isLoop) return false;
      }
    }

    return true;
  }

  private boolean isLoop(final HashMap<Integer, Set<Integer>> map,
                         final Set<Integer> seen,
                         final Set<Integer> entries) {
    if (entries.isEmpty()) {
      return true;
    } else {

      return entries
        .stream()
        .peek(seen::add)
        .allMatch(e -> {
          if (seen.contains(e)) return false;
          return isLoop(map, seen, map.getOrDefault(e, Set.of()));
        });
    }
  }
}
