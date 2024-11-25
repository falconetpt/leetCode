package dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CourseScheduler {
  // x -> y
  // y -> x
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    final var originMap = new HashMap<Integer, Set<Integer>>();
    final var destinationMap = new HashMap<Integer, Set<Integer>>();
    final var seen = new HashSet<Integer>();
    var start = IntStream.range(0, numCourses)
        .boxed()
        .collect(Collectors.toSet());

    fillMaps(prerequisites, originMap, destinationMap, start);

    while (!start.isEmpty()) {
      final var newStart = new HashSet<Integer>();
      for (final var element : start) {
        if (seen.contains(element)) break;
        seen.add(element);
        final var destinations = originMap.getOrDefault(element, Set.of());
        destinations.stream()
            .peek(i -> destinationMap.get(i).remove(element))
            .filter(i ->  destinationMap.get(i).isEmpty())
            .forEach(newStart::add);
      }

      start = newStart;
    }

    return seen.size() == numCourses;
  }

  private void fillMaps(int[][] prerequisites, HashMap<Integer, Set<Integer>> originMap,
                        HashMap<Integer, Set<Integer>> destinationMap, Set<Integer> start) {
    for (final var prerequisite : prerequisites) {
      final var origin = prerequisite[0];
      final var destination = prerequisite[1];
      originMap.putIfAbsent(origin, new HashSet<>());
      destinationMap.putIfAbsent(destination, new HashSet<>());

      originMap.get(origin).add(destination);
      destinationMap.get(destination).add(origin);
      start.remove(destination);
    }
  }
}
