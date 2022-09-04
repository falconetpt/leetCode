package exercises.tree;

import exercises.array.array.helper.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class VerticalTraversal {
  public List<List<Integer>> verticalTraversal(final TreeNode root) {
    final var map = verticalTraversal(root, 0, 0, new TreeMap<>());

    final var result = new ArrayList<List<Integer>>();

    while (!map.isEmpty()) {
      final var next = map.pollFirstEntry();
      final var value = next.getValue();

      result.add(value);
    }

    return result;
  }

  private TreeMap<Integer, List<Integer>> verticalTraversal(final TreeNode root,
                                                            final int row,
                                                            final int col,
                                                            final TreeMap<Integer, List<Integer>> kvMap) {
    if (root == null) {
      return kvMap;
    } else {
      kvMap.putIfAbsent(col, new ArrayList<>());
      kvMap.get(col).add(root.val);

      verticalTraversal(root.left, row + 1, col - 1, kvMap );
      verticalTraversal(root.right, row + 1, col + 1, kvMap );

      return kvMap;
    }
  }
}
