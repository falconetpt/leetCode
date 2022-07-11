package exercises.tree;

import exercises.array.array.helper.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RightSideView {
  public List<Integer> rightSideView(final TreeNode root) {
    final var map = rightSideView(root, new HashMap<>(), 0);
    final var result = new ArrayList<Integer>();
    var level = 0;

    while (map.containsKey(level)) {
      result.add(map.get(level).pollLast());
      level++;
    }

    return result;
  }

  private Map<Integer, LinkedList<Integer>> rightSideView(final TreeNode root,
                                                          final Map<Integer, LinkedList<Integer>> integers,
                                                          int level) {
    if (root == null) {
      return integers;
    } else {
      integers.putIfAbsent(level, new LinkedList<>());
      integers.get(level)
        .addLast(root.val);
      rightSideView(root.left, integers, level + 1);

      return rightSideView(root.right, integers, level + 1);
    }
  }
}
