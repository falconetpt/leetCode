package exercises.tree;

import exercises.array.helper.TreeNode;

public class MaxDepth {
  public int maxDepth(final TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
  }
}
