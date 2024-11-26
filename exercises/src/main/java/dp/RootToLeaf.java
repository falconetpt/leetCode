package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RootToLeaf {
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    return pathSum(root, targetSum, new LinkedList<Integer>(), new ArrayList<List<Integer>>());
  }

  private List<List<Integer>> pathSum(TreeNode root, int targetSum,
                                      LinkedList<Integer> current, List<List<Integer>> result) {
    if (root == null) return result;

    if (root.left == null && root.right == null && targetSum - root.val == 0){
      final var next = new ArrayList<>(current);
      next.add(root.val);
      result.add(next);
      return result;
    }

    current.add(root.val);
    pathSum(root.left, targetSum - root.val, current, result);
    pathSum(root.right, targetSum - root.val, current, result);

    current.pollLast();

    return result;
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
