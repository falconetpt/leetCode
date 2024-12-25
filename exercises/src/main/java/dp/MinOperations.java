package dp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MinOperations {
  public int minimumOperations(TreeNode root) {
    final var hashMap = new HashMap<Integer, ListData>();
    minimumOperations(root, 0, hashMap);

    return hashMap.values()
        .stream()
        .map(this::countDistinct)
        .reduce(0, Integer::sum);
  }

  private int countDistinct(ListData e) {
    final var unsorted = e.unsorted;
    final var sorted = e.sorted;


    var count = 0;
    var isSorted = sorted.equals(unsorted);

    do {
      count++;
    } while (!isSorted);

    return count;
  }

  private void minimumOperations(TreeNode root, int level, HashMap<Integer, ListData> hashMap) {
    if (root != null) {
      hashMap.putIfAbsent(level, new ListData(new LinkedList<>(), new PriorityQueue<>(Comparator.comparingInt(a -> a.val))));
      final var listData = hashMap.get(level);
      listData.unsorted.add(root);
      listData.sorted.add(root);

      minimumOperations(root.left, level + 1, hashMap);
      minimumOperations(root.right, level + 1, hashMap);
    }
  }


  private record ListData(LinkedList<TreeNode> unsorted, PriorityQueue<TreeNode> sorted) {}

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
