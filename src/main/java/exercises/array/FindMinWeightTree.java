package exercises.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class FindMinWeightTree {
  public List<Integer> findMinHeightTrees(final int n, final int[][] edges) {
    final var map = (List<Integer>[]) new List[n];
    Arrays.fill(map, new ArrayList<>());

    for (final var edge : edges) {
      map[edge[0]].add(edge[1]);
      map[edge[1]].add(edge[0]);
    }

    return findMinHeightTrees(map);
  }

  private List<Integer> findMinHeightTrees(final List<Integer>[] map) {
    var min = Integer.MAX_VALUE;
    final var level = new TreeHeight[map.length];
    Arrays.fill(level, new TreeHeight());

    for (int i = 0; i < map.length; i++) {
      final var seen = new boolean[map.length];
      seen[i] = true;
      final var levels = findMinHeightTrees(map[i], map, seen);
      System.out.println("levels = " + levels);
      level[levels].lists.add(i);
      min = Math.min(levels, min);
      seen[i] = false;
    }

    return level[min].lists;
  }

  private int findMinHeightTrees(final List<Integer> elements,
                                 final List<Integer>[] map,
                                 final boolean[] seen) {
      var max = 0;

      for (final var element : elements) {
        if(!seen[element]) {
          seen[element] = true;
          max = Math.max(1 + findMinHeightTrees(map[element], map, seen), max);
          seen[element] = false;
        }
      }

      return max;
    }

  private class TreeHeight {
    final List<Integer> lists = new ArrayList<>();
  }
}
