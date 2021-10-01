package exercises.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CourseSchedule {
  public boolean canFinish(final int numCourses, final int[][] prerequisites) {
    final var allElements = IntStream.range(1, numCourses)
      .boxed()
      .collect(Collectors.toSet());
    final var originSet = new HashSet<Integer>();
    final var dependenciesMap = generateDependenciesMap(prerequisites, originSet);
    final var originPoint = new LinkedList<>(originSet);
    final var seen = new HashSet<Integer>();

    while (!originPoint.isEmpty()) {
      final var element = originPoint.pollFirst();
      if (seen.contains(element)) return false;
      seen.add(element);
      dependenciesMap.getOrDefault(element, List.of())
        .stream()
        .filter(i -> !seen.contains(i))
        .forEach(originPoint::addLast);
      allElements.remove(element);
    }

    return allElements.isEmpty();
  }

  private Map<Integer, List<Integer>> generateDependenciesMap(final int[][] prerequisites,
                                                              final HashSet<Integer> originSet) {
    final var precedencesMap = new HashMap<Integer, List<Integer>>();


    for (final var prerequisite : prerequisites) {
      final var origin = prerequisite[1];
      final var dest = prerequisite[0];
      originSet.add(origin);
      precedencesMap.putIfAbsent(origin, new ArrayList<>());
      precedencesMap.get(origin).add(dest);
    }

    return precedencesMap;
  }
}
