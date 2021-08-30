package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.LinkedList;

public class LowestCommonAncestor {
  public TreeNode lowestCommonAncestor(final TreeNode root,
                                       final TreeNode p,
                                       final TreeNode q) {
    var result = root;
    final var priorityQueue = new LinkedList<TreeNode>(  );
    priorityQueue.add( root );

    while (!priorityQueue.isEmpty()) {
      final var element = priorityQueue.pollFirst();

      if (element.left != null) priorityQueue.add( element.left );
      if (element.right != null) priorityQueue.add( element.right );

      if (hasNode( element, p ) && hasNode( element, q )) result = element;
    }

    return result;
  }

  private boolean hasNode(final TreeNode node, final TreeNode target) {
    if (node == null) {
      return false;
    } else {
      return node == target
        || hasNode( node.left, target )
        || hasNode( node.right, target );
    }
  }
}
