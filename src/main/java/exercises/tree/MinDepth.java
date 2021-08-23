package exercises.tree;

import exercises.array.helper.TreeNode;

public class MinDepth {
  public int minDepth(final TreeNode root) {
    return minDepth(root, 0);
  }

  private int minDepth(final TreeNode node, final int i) {
    if (node == null) {
      return i;
    } else {
      final var left = minDepth(node.left, i + 1);
      final var right = minDepth(node.right, i + 1);

      return right > 1 && left > 1
        ? Math.min(left, right)
        : Math.max(left, right);
    }
  }
}
