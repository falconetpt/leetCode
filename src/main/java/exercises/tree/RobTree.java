package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class RobTree {
  public int rob(final TreeNode root) {
    final var leftMap = new HashMap<Integer, Integer>();
    final var rightMap = new HashMap<Integer, Integer>();
    fillMap(root, 0, leftMap, rightMap, false);
    final var leftResult = new int[leftMap.size() + 2];
    final var rightResult = new int[rightMap.size() + 2];

    for (int i = 2; i < leftResult.length; i++) {
      leftResult[i] = Math.max(leftResult[i-2] + leftMap.get(i - 2), leftResult[i - 1]);
    }

    for (int i = 2; i < rightResult.length; i++) {
      rightResult[i] = Math.max(rightResult[i-2] + rightMap.get(i - 2), rightResult[i - 1]);
    }

    return leftResult[leftResult.length - 1] + rightResult[rightResult.length - 1];
  }

  private void fillMap(final TreeNode root,
                       final int level,
                       final Map<Integer, Integer> leftMap,
                       final HashMap<Integer, Integer> rightMap,
                       final boolean isLeft) {
    if (root != null) {
      if (isLeft) {
        leftMap.put(level, leftMap.getOrDefault(level, 0) + root.val);
      } else {
        rightMap.put(level, rightMap.getOrDefault(level, 0) + root.val);
      }

      fillMap(root.left, level + 1, leftMap, rightMap, true);
      fillMap(root.right, level + 1, leftMap, rightMap, false);
    }
  }
}
