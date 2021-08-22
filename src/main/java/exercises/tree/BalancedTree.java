package exercises.tree;

import exercises.array.helper.TreeNode;

public class BalancedTree {
  public boolean isBalanced(final TreeNode root) {
    if (root == null) {
      return true;
    } else {
      final var left = numberOfNodes(root.left);
      final var right = numberOfNodes(root.right);

      if (Math.abs(left - right) > 1) {
        return false;
      } else {
        return isBalanced(root.left) && isBalanced(root.right);
      }
    }
  }

  public int numberOfNodes(final TreeNode node) {
    if (node == null) {
      return 0;
    } else {
      final var left = numberOfNodes(node.left);
      final var right = numberOfNodes(node.right);

      return 1 + Math.max(left, right);
    }
  }
}
