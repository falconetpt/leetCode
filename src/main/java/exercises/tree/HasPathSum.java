package exercises.tree;

import exercises.array.helper.TreeNode;

public class HasPathSum {
  public boolean hasPathSum(final TreeNode root, final int targetSum) {
    if (root == null) {
      return false;
    } else {
      return hasPath(root, targetSum, 0);
    }
  }

  public boolean hasPath(final TreeNode root, final int targetSum, final int count) {
    if (root == null) {
      return targetSum == 0 && count > 1;
    } else {
      return hasPath(root.left, targetSum - root.val, count + 1)
        || hasPath(root.right, targetSum - root.val, count + 1);
    }
  }
}
