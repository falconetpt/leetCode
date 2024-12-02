package dp;

public class PathSum {
  public int pathSum(TreeNode root, int targetSum) {
    return calculateSum(root, 0, targetSum);
  }

  private int calculateSum(TreeNode root, int sum, int targetSum) {
    if (root == null) return 0;
    final var newSum = sum + root.val;
    var count = 0;
    if (newSum == targetSum) count++;

    return count + calculateSum(root.left, newSum, targetSum)
        + calculateSum(root.right, newSum, targetSum)
        + calculateSum(root.left, 0, targetSum)
        + calculateSum(root.right, 0, targetSum);
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
