package exercises.tree;

import exercises.array.array.helper.TreeNode;

public class TrimBST {
  public TreeNode trimBST(TreeNode root, int low, int high) {
    if (root == null) return null;
    if (root.val > high) return trimBST(root.left, low, high);
    if (root.val < low) return trimBST(root.right, low, high);

    root.left = trimBST(root.left, low, high);
    root.right = trimBST(root.right, low, high);

    return root;
  }
}
