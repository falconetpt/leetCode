package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PruneTree {
  public TreeNode pruneTree(TreeNode root) {
    pruneTreeNode(root, new HashMap<>());

    return root;
  }

  private boolean pruneTreeNode(final TreeNode root, Map<TreeNode, Boolean> cache) {
    if (root == null) {
      return true;
    } else if (cache.containsKey(root)) {
      return cache.get(root);
    } else {
      if (root.val == 1) cache.put(root, false);

      pruneTreeNode(root.left, cache);
      pruneTreeNode(root.right, cache);

      if (cache.getOrDefault(root.left, true)) root.left = null;
      if (cache.getOrDefault(root.right, true)) root.right = null;
      if (cache.getOrDefault(root.right, true)
        && cache.getOrDefault(root.left, true)
        && root.val != 1) cache.put(root, true);


      return cache.get(root);
    }
  }
}
