package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class FenceOnTrees {
  public int[][] outerTrees(int[][] trees) {
    final var xMap = new TreeMap<Integer, int[]>();

    for (final var tree : trees) {
      xMap.putIfAbsent(tree[0], new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE });
      final var element = xMap.get(tree[0]);
      element[0] = Math.min(element[0], tree[1]);
      element[1] = Math.max(element[1], tree[1]);
    }

    final var result = new ArrayList<int[]>();

    for (final var entry : xMap.entrySet()) {
      final var key = entry.getKey();
      final var value = entry.getValue();
      result.add(new int[] {key, value[0]});
      if (value[1] != value[0]) result.add(new int[] {key, value[1]});

    }

    return result.toArray(int[][]::new);
  }
}
