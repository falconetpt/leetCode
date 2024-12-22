package dp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ReverseNoe {
  public TreeNode reverseOddLevels(TreeNode root) {
    final var map = getNodesOfOddLevels(root, 0, new HashMap<>());

    map.values().forEach(this::swapElements);

    return root;
  }

  private void swapElements(LinkedList<TreeNode> treeNodes) {
    while (treeNodes.size() > 1) {
      final var first = treeNodes.pollFirst();
      final var last = treeNodes.pollLast();
      final var firstValue = first.val;
      final var lastValue = last.val;
      first.val = lastValue;
      last.val = firstValue;
    }
  }

  private Map<Integer, LinkedList<TreeNode>> getNodesOfOddLevels(TreeNode root,
                                                                 int level,
                                                                 Map<Integer, LinkedList<TreeNode>> map) {
    if (root == null) return map;

    if (level % 2 == 1) {
      map.putIfAbsent(level, new LinkedList<>());
      map.get(level).add(root);
    }


    getNodesOfOddLevels(root.left, level + 1, map);
    getNodesOfOddLevels(root.right, level + 1, map);

    return map;
  }


  public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
