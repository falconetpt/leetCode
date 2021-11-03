package exercises.tree;

import exercises.array.helper.TreeNode;

public class SumLeafs {
  public int sumNumbers(final TreeNode root) {
    return sumNumbers(root, 0);
  }

  private int sumNumbers(final TreeNode root, final int sum) {
    if (root == null) {
      return sum;
    } else {
      if (root.left == null && root.right == null) return sum * 10 + root.val;

      final var left = root.left == null
        ? 0
        : sumNumbers(root.left, sum * 10 + root.val);
      final var right = root.right == null
        ? 0
        : sumNumbers(root.right, sum * 10 + root.val);

      return left + right;
    }
  }
}
