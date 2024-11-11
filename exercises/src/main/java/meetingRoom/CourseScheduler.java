package meetingRoom;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.IntStream;

public class CourseScheduler {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    final var pool = new HashSet<Integer>();
    IntStream.range(0, numCourses).forEach(pool::add);
    final var seen = new HashSet<Integer>();

    final var originMap = new HashMap<Integer, Set<Integer>>();
    final var destinationMap = new HashMap<Integer, Set<Integer>>();

    fillMaps(prerequisites, originMap, destinationMap, pool);

    return canFinish(new LinkedList<>(pool), seen, originMap, destinationMap, numCourses);
  }

  private boolean canFinish(LinkedList<Integer> pool, HashSet<Integer> seen,
                            HashMap<Integer, Set<Integer>> originMap, HashMap<Integer, Set<Integer>> destinationMap,
                            int numCourses) {
    if (pool.isEmpty()) {
      return seen.size() == numCourses;
    } else {
      final var element = pool.pollLast();

      if(seen.contains(element)) return false;
      seen.add(element);

      originMap.getOrDefault(element, Set.of())
          .stream()
          .filter(e -> !seen.contains(e))
          .forEach(e -> {
            destinationMap.getOrDefault(e, Set.of()).remove(element);
            if(destinationMap.getOrDefault(e, Set.of()).isEmpty()) pool.add(e);
          });

      return canFinish(pool, seen, originMap, destinationMap, numCourses);
    }

  }

  private static void fillMaps(int[][] prerequisites,
                               HashMap<Integer, Set<Integer>> originMap,
                               HashMap<Integer, Set<Integer>> destinationMap,
                               HashSet<Integer> pool) {
    for (int i = 0; i < prerequisites.length; i++) {
      final var element = prerequisites[i];
      final var origin = element[0];
      final var destination = element[1];

      originMap.putIfAbsent(origin, new HashSet<>());
      originMap.get(origin).add(destination);
      destinationMap.putIfAbsent(destination, new HashSet<>());
      destinationMap.get(destination).add(origin);

      pool.remove(destination);
    }
  }
}
