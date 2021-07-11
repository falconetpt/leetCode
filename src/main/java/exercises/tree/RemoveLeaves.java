package exercises.tree;

import exercises.array.helper.TreeNode;

public class RemoveLeaves {
  public TreeNode removeLeafNodes(final TreeNode root, final int target) {
    if (root != null) {
      removeLeafNodes(root.left, target);
      removeLeafNodes(root.right, target);

      if (isValueInLeaf(root.left, target)) root.left = null;
      if (isValueInLeaf(root.right, target)) root.right = null;
      if (isValueInLeaf(root, target)) return null;

      return root;

    } else {
      return null;
    }
  }

  private boolean isValueInLeaf(final TreeNode left, final int target) {
    return left != null
      && left.right == null
      && left.left == null
      && left.val == target;
  }
}
