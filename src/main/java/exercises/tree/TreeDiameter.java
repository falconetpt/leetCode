package exercises.tree;

import exercises.array.helper.TreeNode;

public class TreeDiameter {
  public class NodeInfo {
    public int diameter=0, maxDepth = 0;
  }

  public int diameterOfBinaryTree(TreeNode root) {
    return voyager(root).diameter;
  }

  public NodeInfo voyager(TreeNode node) {
    if(node == null) return new NodeInfo();

    NodeInfo result = new NodeInfo();

    NodeInfo left = voyager(node.left);
    result.maxDepth = Math.max(left.maxDepth+1, result.maxDepth);

    NodeInfo right = voyager(node.right);
    result.maxDepth = Math.max(right.maxDepth+1, result.maxDepth);

    result.diameter = Math.max(left.maxDepth + right.maxDepth, Math.max(left.diameter, right.diameter));

    return result;
  }
}
