package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Cousin {
  public boolean isCousins(final TreeNode root, final int x, final int y) {
    final var map = fillMap(root, 0, null, new HashMap<>());
    final var xValue = map.getOrDefault(x, null);
    final var yValue = map.getOrDefault(y, null);

    if (xValue == null || yValue == null) return false;

    return xValue.parent != yValue.parent
      && xValue.level == yValue.level;
  }

  private Map<Integer, Value> fillMap(final TreeNode root,
                                      final int i,
                                      final TreeNode parent,
                                      final Map<Integer, Value> integerValueHashMap) {
    if (root == null) {
      return integerValueHashMap;
    } else {
      integerValueHashMap.put(root.val, new Value(i, parent));

      fillMap(root.left, i + 1, root, integerValueHashMap);
      fillMap(root.right, i + 1, root, integerValueHashMap);

      return integerValueHashMap;
    }
  }

  private class Value {
    private int level;
    private TreeNode parent;

    public Value(final int level, final TreeNode parent) {
      this.level = level;
      this.parent = parent;
    }
  }
}
