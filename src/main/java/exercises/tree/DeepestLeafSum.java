package exercises.tree;

import exercises.array.array.helper.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DeepestLeafSum {
  public int deepestLeavesSum(final TreeNode root) {
    final var map = new LinkedHashMap<Integer, List<TreeNode>>();

    return map.get(deepestLeavesSum(root, map, 0) - 1)
      .stream()
      .map(t -> t.val)
      .reduce(0, Integer::sum);
  }

  private int deepestLeavesSum(final TreeNode node, final Map<Integer, List<TreeNode>> map,
                               final Integer level) {
    if (node == null) {
      return level;
    } else {
      map.putIfAbsent(level, new ArrayList<>());
      map.get(level).add(node);
      return Math.max(deepestLeavesSum(node.left, map, level + 1),
        deepestLeavesSum(node.right, map, level + 1));
    }
  }
}
