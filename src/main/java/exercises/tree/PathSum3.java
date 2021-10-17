package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class PathSum3 {
  public int pathSum(final TreeNode root, final int targetSum) {
    final var result = new AtomicInteger(0);
    pathSum(root, new HashSet<>(), targetSum, result);

    return result.intValue();
  }

  private int pathSum(final TreeNode root,
                      final Set<TreeNode> list,
                      final int targetSum,
                      final AtomicInteger atomicInteger) {
    if (root == null) {
      return 0;
    } else {
      final var value = root.val;
      final var newSet = new HashSet<TreeNode>();
      if (value == targetSum) atomicInteger.getAndIncrement();

      list.stream()
        .map(e -> new TreeNode(e.val + value))
        .peek(e -> { if (e.val == targetSum) atomicInteger.getAndIncrement(); })
        .forEach(newSet::add);

      newSet.add(root);

      pathSum(root.left, newSet, targetSum, atomicInteger);
      pathSum(root.right, newSet, targetSum, atomicInteger);

      return value;
    }
  }
}
