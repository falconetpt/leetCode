package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.HashSet;

public class LowestCommon {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    return findNode(root, q, p, root);
  }

  private TreeNode findNode(final TreeNode root,
                            final TreeNode q,
                            final TreeNode p,
                            final TreeNode lowestCommon) {
    if (containsNode(root, q, p)) {
      final var right = findNode(root.right, q, p, root);
      return right == lowestCommon
        ?  findNode(root.left, q, p, root)
        : right;
    } else {
      return lowestCommon;
    }
  }

  private boolean containsNode(final TreeNode root, final TreeNode q, final TreeNode p) {
    if (root == null) {
      return false;
    } else {
      final var qFound = hasNode(root, q);
      final var pFound = hasNode(root, q);

      return qFound && pFound;
    }
  }

  private boolean hasNode(final TreeNode root, final TreeNode q) {
    if (root == null) {
      return false;
    } else {
      return root == q
        || hasNode(root.left, q)
        || hasNode(root.right, q);
    }
  }
}
