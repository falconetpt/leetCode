package exercises.tree;

import exercises.array.array.helper.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WidthBinaryTree {
  public int widthOfBinaryTree(final TreeNode root) {
    if (root == null) return 0;
    final var map = new HashMap<Integer, List<Boolean>>();

    map.put(0, new ArrayList<>());
    map.get(0).add(true);

    widthOfBinaryTree(root, 0, map);

    var max = 0;

    for (final var element : map.values()) {
      max = Math.max(calculate(element), max);
    }

    return max;
  }

  private int calculate(final List<Boolean> element) {
    var start = 0;
    var end = element.size() - 1;

    while (start < end) {
      final var startValid = element.get(start);
      final var endValid = element.get(end);
      if (startValid && endValid) return end - start + 1;

      if (startValid) {
        end--;
      } else {
        start++;
      }
    }

    return end - start + 1;
  }

  private Map<Integer, List<Boolean>> widthOfBinaryTree(final TreeNode root,
                                                    final int level,
                                                    final Map<Integer, List<Boolean>> integerHashMap) {
    if (root == null) {
      if (integerHashMap.get(level) != null) {
        integerHashMap.get(level + 1).add(root.left != null);
        integerHashMap.get(level + 1).add(root.right != null);
        widthOfBinaryTree(null, level + 1, integerHashMap);
        widthOfBinaryTree(null, level + 1, integerHashMap);
      }
      return integerHashMap;
    } else {
      integerHashMap.putIfAbsent(level + 1, new ArrayList<>());

      integerHashMap.get(level + 1).add(root.left != null);
      integerHashMap.get(level + 1).add(root.right != null);

      widthOfBinaryTree(root.left, level + 1, integerHashMap);
      widthOfBinaryTree(root.right, level + 1, integerHashMap);

      return integerHashMap;
    }
  }
}
