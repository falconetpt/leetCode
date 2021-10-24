package exercises.tree;

import exercises.array.helper.TreeNode;

public class CountCompleteNodes {
  public int countNodes(final TreeNode root) {
    if (root == null) return 0;
    return 1
      + countNodes(root.left)
      + countNodes(root.right);
  }
}
