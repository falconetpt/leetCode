package exercises.blind;

import exercises.array.helper.TreeNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallest {
  public int kthSmallest(final TreeNode root, int k) {
    final var priority = new PriorityQueue<Integer>(Comparator.comparing(a -> -a));

    findSmallest(root, k, priority);

    return priority.peek();
  }

  private void findSmallest(final TreeNode root, final int k, final PriorityQueue<Integer> priority) {
    if (root != null && priority.size() < k) {
      findSmallest(root.left, k, priority);
      if (priority.size() < k) {
        priority.add(root.val);
        findSmallest(root.right, k, priority);
      }
    }
  }
}
