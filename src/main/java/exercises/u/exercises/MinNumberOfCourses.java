package exercises.u.exercises;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MinNumberOfCourses {

  public int minNumberSemesters(int n, int[][] courses) {
    final var coursesAvailable = IntStream.rangeClosed(1, n)
        .boxed()
        .collect(Collectors.toCollection(HashSet::new));
    final var fromMap = new HashMap<Integer, Course>();
    final var toMap = new HashMap<Integer, Course>();

    fillMaps(courses, coursesAvailable, fromMap, toMap);

    if (courses.length == 0) return -1;

    final var queue = new LinkedList<>(coursesAvailable);
    var count = 0;
    var semesters = 0;

    final var seen = new HashSet<Integer>();

    while (!queue.isEmpty()) {
      final var list = new LinkedList<>(queue);
      queue.clear();
      list.stream()
          .flatMap(element -> computeConnections(element, fromMap, toMap, seen))
          .forEach(queue::add);
      semesters += 1;
      count += list.size();
    }

    return count == n
        ? semesters
        : -1;
  }

  private Stream<Integer> computeConnections(int element, HashMap<Integer, Course> fromMap, HashMap<Integer, Course> toMap, HashSet<Integer> seen) {
    final var allConnections = fromMap.getOrDefault(element, new Course())
        .connectedTo;
    seen.add(element);

    return allConnections.stream()
        .filter(c -> !seen.contains(c))
        .peek(c -> toMap.get(c).remove(element))
        .filter(c -> toMap.get(c).readyToPickUp());
  }

  private void fillMaps(int[][] courses,
                        HashSet<Integer> coursesAvailable,
                        HashMap<Integer, Course> fromMap,
                        HashMap<Integer, Course> toMap) {
    for (int i = 0; i < courses.length; i++) {
      final var from = courses[i][0];
      final var to = courses[i][1];

      coursesAvailable.remove(to);

      // from map
      fromMap.putIfAbsent(from, new Course());

      final var courseFrom = fromMap.get(from);
      courseFrom.add(to);

      // to map
      toMap.putIfAbsent(to, new Course());

      final var courseTo = toMap.get(to);
      courseTo.add(from);
    }
  }


  private class Course {
    public Set<Integer> connectedTo;

    public Course() {
      connectedTo = new HashSet<>();
    }
    
    public void add(Integer blockedBy) {
      this.connectedTo.add(blockedBy);
    }

    public void remove(int element) {
      connectedTo.remove(element);
    }

    public void remove(Set<Integer> elements) {
      connectedTo.removeAll(elements);
    }

    public boolean readyToPickUp() {
      return connectedTo.isEmpty();
    }
  }
}
