package exercises.tree;

import exercises.array.helper.TreeNode;

public class IsSameTree {
  public boolean isSameTree(final TreeNode p, final TreeNode q) {
    if (p == null && q == null) {
      return true;
    } else {
      if (p != null && q != null) {
        return p.val == q.val
          && isSameTree(p.left, q.left)
          && isSameTree(p.right, q.right);
      } else {
        return false;
      }
    }
  }
}
