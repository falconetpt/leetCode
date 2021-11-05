package exercises.tree;

import exercises.array.helper.TreeNode;

public class SumLeftLeaves {
  public int sumOfLeftLeaves(final TreeNode root) {
    if (root == null) return 0;
    return sumOfLeftLeaves(root.left, true)
      + sumOfLeftLeaves(root.right, false);
  }

  private int sumOfLeftLeaves(final TreeNode node,
                              final boolean isLeft) {
    if (node == null) {
      return 0;
    } else {
      if (node.left == null && node.right == null) {
        return isLeft
          ? node.val
          : 0;
      }

      return sumOfLeftLeaves(node.left, true)
        + sumOfLeftLeaves(node.right, false);
    }
  }
}
