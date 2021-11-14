package exercises.blind;

import exercises.array.helper.TreeNode;

public class LowestCommonAncestorMed {
  public TreeNode lowestCommonAncestor(final TreeNode root,
                                       final TreeNode p,
                                       final TreeNode q) {
    if (root != null) {
      final var exist = find(root, p) && find(root, q);

      if (exist) {
        final var left = lowestCommonAncestor(root.left, p, q);
        final var rigth = lowestCommonAncestor(root.left, p, q);

        if (left == null) {
          return rigth == null
            ? root
            : rigth;
        } else {
          return left;
        }
      }
    }
    return null;
  }

  private boolean find(final TreeNode root, final TreeNode node) {
    if (root == null) {
      return false;
    } else {
      if (root == node) return true;
      return find(root.right, node)
        || find(root.left, node);
    }
  }
}
