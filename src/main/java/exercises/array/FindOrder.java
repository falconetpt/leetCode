package exercises.array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindOrder {
  public int[] findOrder(final int numCourses, final int[][] prerequisites) {
    final var elements = IntStream.range(0, numCourses)
      .mapToObj(Element::new)
      .collect(Collectors.toList());
    final var root = IntStream.range(0, numCourses)
      .mapToObj(elements::get)
      .collect(Collectors.toSet());

    for (final var prerequisite : prerequisites) {
      final var parent = elements.get(prerequisite[1]);
      final var child = elements.get(prerequisite[0]);

      parent.children.add(child);
      root.remove(child);
    }

    final var result = findOrder(new LinkedList<>(root), new ArrayList<>())
      .stream()
      .mapToInt(i -> i.value)
      .toArray();

    return result.length == numCourses
      ? result
      : new int[] {};
  }

  private List<Element> findOrder(final LinkedList<Element> root, final List<Element> integers) {
    final var seen = new HashSet<Integer>();

    while (!root.isEmpty()) {
      final var element = root.pollFirst();
      if (!seen.contains(element.value)) {
        integers.add(element);
        root.addAll(element.children);
        seen.add(element.value);
      }
    }

    return integers;
  }

  private class Element {
    private int value;
    private final List<Element> children;

    public Element(final int value) {
      this.value = value;
      children = new ArrayList<>();
    }
  }
}
