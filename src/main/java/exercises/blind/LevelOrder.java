package exercises.blind;

import exercises.array.helper.TreeNode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LevelOrder {
  public List<List<Integer>> levelOrder(final TreeNode root) {
    final var map = new LinkedHashMap<Integer, List<Integer>>();

    return new ArrayList<>(levelOrder(root, 0, map)
      .values());
  }

  private Map<Integer, List<Integer>> levelOrder(final TreeNode root, final int i, final Map<Integer, List<Integer>> map) {
    if (root != null) {
      map.putIfAbsent(i, new ArrayList<>());
      map.get(i).add(root.val);
      levelOrder(root.left, i + 1, map);
      levelOrder(root.right, i + 1, map);

    }
    return map;

  }
}
