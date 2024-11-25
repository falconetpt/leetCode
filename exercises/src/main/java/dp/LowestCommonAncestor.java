package dp;

import java.util.HashSet;

public class LowestCommonAncestor {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    return lowestCommonAncestor(root, p, q, new HashSet<TreeNode>());
  }

  private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, HashSet<TreeNode> treeNodes) {
    if (root == null) return null;

    final var leftSeen = new HashSet<TreeNode>();
    final var rightSeen = new HashSet<TreeNode>();

    final var left = lowestCommonAncestor(root.left, p, q, leftSeen);
    final var right = lowestCommonAncestor(root.right, p, q, rightSeen);
    treeNodes.add(root);
    treeNodes.addAll(leftSeen);
    treeNodes.addAll(rightSeen);


    if (left != null || right != null) return left == null ? right : left;
    if (treeNodes.contains(p) && treeNodes.contains(q)) return root;
    return null;
  }


  public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
   }
}
