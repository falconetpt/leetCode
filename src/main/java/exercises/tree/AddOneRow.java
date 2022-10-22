package exercises.tree;

import exercises.array.array.helper.TreeNode;

public class AddOneRow {
  public TreeNode addOneRow(final TreeNode root, final int val, final int depth) {
    if (depth == 1) {
      final var result = new TreeNode(val);
      result.left = root;
      return result;
    }

    addRow(root, val, depth);

    return root;
  }

  private void addRow(final TreeNode root, final int val, final int depth) {
    if (depth == 2) {
      final var left = root.left;
      final var right = root.right;

      final var newLeftNode = new TreeNode(val);
      newLeftNode.left = left;
      final var newRightNode = new TreeNode(val);
      newRightNode.right = right;

      root.left = newLeftNode;
      root.right = newRightNode;
    } else {
      if(root.left != null) addRow(root.left, val, depth - 1);
      if(root.right != null) addRow(root.right, val, depth - 1);
    }
  }
}
