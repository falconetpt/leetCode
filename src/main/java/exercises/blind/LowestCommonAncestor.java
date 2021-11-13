package exercises.blind;

import exercises.array.helper.TreeNode;

public class LowestCommonAncestor {
  public TreeNode lowestCommonAncestor(final TreeNode root,
                                       final TreeNode p,
                                       final TreeNode q) {
    if (p.val > q.val) return lowestCommonAncestor(root, q, p);
    if (p.val == root.val) return p;
    if (q.val == root.val) return q;

    if (p.val < root.val && q.val > root.val) return root;

    return root.val > q.val
      ? lowestCommonAncestor(root.left, p, q)
      : lowestCommonAncestor(root.right, p, q);
  }
}
