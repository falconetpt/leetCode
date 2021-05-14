package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.LinkedList;

public class Flatten {
  public void flatten(final TreeNode root) {
    LinkedList<TreeNode> treeNodes = flatten(root, new LinkedList<>());
    TreeNode nextNode = treeNodes.pollFirst();

    while (!treeNodes.isEmpty()) {
      nextNode.left = null;
      nextNode.right = treeNodes.pollFirst();
      nextNode = nextNode.right;
    }

  }

  private LinkedList<TreeNode> flatten(TreeNode root, LinkedList<TreeNode> es) {
    if (root == null) {
      return es;
    } else {
      es.add(root);
      flatten(root.left, es);
      return flatten(root.right, es);
    }
  }
}
