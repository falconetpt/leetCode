package dp;

import u.exercises.KThSmallesBST;
import u.exercises.KThSmallesBST.TreeNode;

import java.util.HashSet;

public class LCA {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    return lowestCommonAncestor(root, p, q, new HashSet<TreeNode>());
  }

  private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, HashSet<TreeNode> treeNodes) {
    if (root == null) return null;

    final var leftSeen = new HashSet<>(treeNodes);
    final var rightSeen = new HashSet<>(treeNodes);
    final var left = lowestCommonAncestor(root.left, p, q, leftSeen);
    final var right = lowestCommonAncestor(root.right, p, q, rightSeen);

    if (left != null) return left;
    if (right != null) return right;

    treeNodes.add(root);
    treeNodes.addAll(leftSeen);
    treeNodes.addAll(rightSeen);

    if (treeNodes.contains(p) && treeNodes.contains(q)) return root;
    return null;
  }
}
