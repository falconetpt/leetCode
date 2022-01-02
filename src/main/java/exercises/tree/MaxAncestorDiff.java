package exercises.tree;

import exercises.array.array.helper.TreeNode;

public class MaxAncestorDiff {
  public int maxAncestorDiff(final TreeNode root) {
    return maxAncestorDiff(root, root.val, root.val);
  }

  private int maxAncestorDiff(final TreeNode root, final int min, final int max) {
    if (root == null) {
      return 0;
    } else {
      final var valueMin = Math.abs(root.val - max);
      final var valueMax = Math.abs(root.val - min);
      final var maxDiff = Math.max(valueMin, valueMax);

      final var left = Math.max(maxDiff, maxAncestorDiff(root.left, Math.min(min, root.val), Math.max(max, root.val)));
      final var right = Math.max(maxDiff, maxAncestorDiff(root.right, Math.min(min, root.val), Math.max(max, root.val)));

      return Math.max(maxDiff, Math.max(left, right));
    }
  }
}
