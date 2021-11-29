package exercises.array;

import java.util.ArrayList;
import java.util.List;

public class AllPathsSourceTarget {
  public List<List<Integer>> allPathsSourceTarget(final int[][] graph) {
    return allPathsSourceTarget(graph, 0, new ArrayList<>(), new ArrayList<Integer>());
  }

  private List<List<Integer>> allPathsSourceTarget(final int[][] graph,
                                                   final int i,
                                                   final List<List<Integer>> lists,
                                                   final List<Integer> currentList) {
    if(i == graph.length - 1) {
      currentList.add(i);
      lists.add(new ArrayList<>(currentList));
      currentList.remove(currentList.size() - 1);
      return lists;
    } if (graph[i].length == 0) {
      return lists;
    } else {
      final var elements = graph[i];

      for (final var element : elements) {
        currentList.add(i);
        allPathsSourceTarget(graph, element, lists, currentList);
        currentList.remove(currentList.size() - 1);
      }

      return lists;
    }
  }
}
