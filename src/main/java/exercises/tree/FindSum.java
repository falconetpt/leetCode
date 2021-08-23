package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class FindSum {
  public boolean findTarget(final TreeNode root, int k) {
    return findTarget(root, k, new HashSet<Integer>());
  }

  private boolean findTarget(final TreeNode root, final int k, final Set<Integer> integers) {
    if (root == null) {
      return false;
    } else {
      final var dif = k - root.val;

      if (integers.contains(dif)) return true;
      integers.add(root.val);
      return findTarget(root.left, k, integers)
        || findTarget(root.right, k, integers);
    }
  }
}
