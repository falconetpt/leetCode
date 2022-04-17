package exercises.tree;

import exercises.array.array.helper.TreeNode;

import javax.swing.text.html.Option;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ConvertGreaterTree {
  public TreeNode convertBST(final TreeNode root) {
    final var tree = new TreeMap<Integer, Integer>();
    convertBST(root, tree);
    return root;
  }

  public void convertBST(final TreeNode root,
                         final TreeMap<Integer, Integer> treeMap) {
    if (root != null) {
      convertBST(root.right, treeMap);
      final var greaterThen = Optional.ofNullable(treeMap.ceilingEntry(root.val))
        .map(Map.Entry::getValue)
        .orElse(0);
      treeMap.put(root.val, greaterThen + root.val);
      root.val = greaterThen + root.val;
      convertBST(root.left, treeMap);
    }
  }
}
