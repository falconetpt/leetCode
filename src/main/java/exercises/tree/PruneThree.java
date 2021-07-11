package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.Objects;
import java.util.stream.Stream;

public class PruneThree {
  public TreeNode pruneTree(final TreeNode root) {
    if (root != null) {
      if (hasValue(root.right, 1)) {
        pruneTree(root.right);
      } else {
        root.right = null;
      }

      if (hasValue(root.left, 1)) {
        pruneTree(root.left);
      } else {
        root.left = null;
      }

    }

    return Stream.of(root.left, root.right)
    .allMatch(Objects::isNull) && root.val != 1
      ? null
      : root;
  }

  private boolean hasValue(final TreeNode node, final int value) {
    if (node == null) {
      return false;
    } else {
      if (node.val == value) return true;
      return hasValue(node.left, value)
        || hasValue(node.right, value);
    }
  }
}
