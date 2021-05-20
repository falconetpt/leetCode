package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LevelOrderTraversal {
  public List<List<Integer>> levelOrder(final TreeNode root) {

    return new ArrayList<>(
      constructMap(root, 0, new TreeMap<>())
      .values()
    );

  }

  private TreeMap<Integer, List<Integer>> constructMap(final TreeNode node,
                                                 final int level,
                                                 final TreeMap<Integer,  List<Integer>> treeMap) {
    if (node == null) {
      return treeMap;
    } else {
      treeMap.putIfAbsent(level, new ArrayList<>());
      treeMap.get(level).add(node.val);

      constructMap(node.left, level + 1, treeMap);
      return constructMap(node.right, level + 1, treeMap);
    }
  }
}
